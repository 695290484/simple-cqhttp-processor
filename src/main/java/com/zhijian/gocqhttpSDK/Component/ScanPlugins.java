package com.zhijian.gocqhttpSDK.Component;

import com.alibaba.fastjson.JSON;
import com.zhijian.gocqhttpSDK.Annotation.PostType;
import com.zhijian.gocqhttpSDK.SDKApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@Configuration
public class ScanPlugins {

    @Resource
    private ConfigurableEnvironment springEnv;

    @PostConstruct()
    public void init(){
        // 扫描Plugins包 将@PostType注解的处理器注册进去
        String basePackage = "com.zhijian.gocqhttpSDK.Plugins";

        List<PluginInfo> pluginCollection = new ArrayList<>();

        try {
            Set<Class<?>> set2 = new Scanner().getAnnotationClasses(basePackage, PostType.class);
            List<Class<?>> list = new ArrayList<>();
            list.addAll(set2);

            // 放入pluginCollection
            for (Class<?> c : list) {
                PluginInfo pi = new PluginInfo();
                pi.PluginClass = c.getName();
                pi.PluginObject = ApplicationContextProvider.getBean(c);
                pi.PluginName = c.getAnnotation(PostType.class).pluginName();
                pi.PluginOrder = c.getAnnotation(PostType.class).order();
                pi.PostType = c.getAnnotation(PostType.class).value().name();
                pi.fromJar = 0;
                pluginCollection.add(pi);
            }

            // 如果是jar包形式启动那么扫描同目录下的Plugins文件夹jar插件
            if ("jar".equalsIgnoreCase(SDKApplication.class.getResource("").getProtocol())) {
                String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
                path = java.net.URLDecoder.decode(path, "UTF-8");
                path = path.substring(0, path.lastIndexOf(".jar")).replace("/", "\\");
                path = path.substring(6, path.lastIndexOf(File.separator)) + "\\Plugins";

                File pluginPath = new File(path);

                if (pluginPath.isDirectory()){

                    Map<String, List<URL>> urlMap = new HashMap<>();
                    visitAndSaveFile(urlMap, pluginPath, true, pluginPath);

                    for(Map.Entry<String, List<URL>> ent: urlMap.entrySet()) {
                        path = ent.getKey();
                        List<URL> files = ent.getValue();

                        URL[] urls = new URL[files.size()];
                        URLClassLoader urlClassLoader = new URLClassLoader(files.toArray(urls));

                        List<PluginInfo> listPlugins = new ArrayList<>();

                        for (URL url: files) {

                            File f = new File(url.getPath());
                            String className = null;
                            Object o = null;
                            Object initObject = null;
                            JarFile jarFile = null;
                            try {
                                jarFile = new JarFile(f.getPath());
                                Enumeration<JarEntry> entries = jarFile.entries();
                                List<String> classNames = getClassNames(entries);
                                for (String x : classNames) {
                                    if (x.equals("Plugin")) {
                                        initObject = loadAndInstanceClass(x, urlClassLoader);
                                        className = x;
                                    } else if (x.contains(".Plugins.")) {
                                        o = loadAndInstanceClass(x, urlClassLoader);
                                        className = x;
                                        Annotation[] annotations = o.getClass().getAnnotations();
                                        for (int i = 0; i < annotations.length; ++i) {
                                            Annotation an = annotations[i];
                                            if (an.annotationType().toString().endsWith(".PostType")) {
                                                PluginInfo pi = new PluginInfo();
                                                pi.PluginClass = o.getClass().getName();
                                                pi.PluginObject = o;
                                                pi.fromJar = 1;

                                                Map<String, Object> stringObjectMap = transStringToMap(an.toString().substring(an.toString().indexOf("(") + 1, an.toString().length() - 1), ",", "=");

                                                pi.PluginName = stringObjectMap.get("pluginName") == null ? "" : stringObjectMap.get("pluginName").toString();
                                                pi.PluginOrder = Integer.parseInt(stringObjectMap.get("order").toString());
                                                pi.PostType = stringObjectMap.get("value").toString();
                                                listPlugins.add(pi);
                                            }
                                        }
                                    }
                                }


                            } catch (IOException e) {
                                e.printStackTrace();
                            } finally {
                                if (jarFile != null) {
                                    try {
                                        jarFile.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                            if (null != initObject && null != className) {
                                Method method = initObject.getClass().getDeclaredMethod("init", String.class);

                                // 获取所有application.properties文件中的配置并传给插件
                                ResourceBundle bean = ResourceBundle.getBundle("application");
                                Enumeration<String> keys = bean.getKeys();
                                Map<String, Object> keyMap = new HashMap<>();
                                while (keys.hasMoreElements()) {
                                    String key = keys.nextElement();
                                    keyMap.put(key, bean.getObject(key));
                                }

                                method.invoke(initObject, JSON.toJSONString(keyMap));
                            }

                        }

                        // 将外部jar插件放入pluginCollection
                        pluginCollection.addAll(listPlugins);
                    }
                }
            }

            // 排序后注册插件
            pluginCollection.sort(((o1, o2) -> o1.PluginOrder - o2.PluginOrder));
            for (PluginInfo p:pluginCollection){
                EventHandler.regist(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> getClassNames(Enumeration<JarEntry> entries) {
        List<String> classNames = new ArrayList<String>();
        while (entries.hasMoreElements()) {
            JarEntry nextElement = entries.nextElement();
            String name = nextElement.getName();

            if (name.endsWith(".class")) {
                String replace = name.replace(".class", "").replace("/", ".");
                classNames.add(replace);
            }
        }
        return classNames;
    }

    private static Object loadAndInstanceClass(String clazzName, ClassLoader classLoader) {
        try {
            Class<?> forName = classLoader.loadClass(clazzName);
            try {
                Object newInstance = forName.newInstance();
                System.out.println(newInstance);
                return newInstance;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void visitAndSaveFile(Map<String, List<URL>> map, File dir, boolean first, File currentDir) throws MalformedURLException {
        // 首个目录直接添加
        if(first && dir.isDirectory() && dir.listFiles().length>0) {
            map.put(dir.getPath(), new ArrayList<>());
            currentDir = dir;
        }

        if (dir.isDirectory()) {
            String[] children = dir.list();
            if(children.length>0){
                currentDir = dir;
                List<URL> urls = map.get(dir.getPath());
                if(urls == null) map.put(dir.getPath(), new ArrayList<>());

                for (int i = 0; i < children.length; i++) {
                    visitAndSaveFile(map, new File(dir, children[i]), false, currentDir);
                }
            }

        }else{
            List<URL> urls = map.get(currentDir.getPath());
            if(null == urls) {
                urls = new ArrayList<>();
                map.put(currentDir.getPath(), urls);
            }
            urls.add(dir.toURI().toURL());
        }

    }

    private static Map<String, Object> transStringToMap(String mapString, String separator, String pairSeparator) {
        Map<String, Object> map = new HashMap<String, Object>();
        String[] fSplit = mapString.split(separator);
        for (int i = 0; i < fSplit.length; i++) {
            if (fSplit[i]==null||fSplit[i].length()==0) {
                continue;
            }
            String[] sSplit = fSplit[i].split(pairSeparator);
            String value = fSplit[i].substring(fSplit[i].indexOf('=') + 1, fSplit[i].length());
            map.put(sSplit[0].trim(), value);
        }

        return map;
    }

}
