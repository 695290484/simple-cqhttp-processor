package com.zhijian.gocqhttpSDK.Component;

import com.zhijian.gocqhttpSDK.Annotation.PostType;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class ScanPlugins {

    @PostConstruct()
    public void init(){
        // 扫描Plugins包 将@PostType注解的处理器注册进去
        String basePackage = "com.zhijian.gocqhttpSDK.Plugins";

        try {
            Set<Class<?>> set2 = new Scanner().getAnnotationClasses(basePackage, PostType.class);
            // 按order排序
            List<Class<?>> list = new ArrayList<>();
            list.addAll(set2);
            list.sort(((o1, o2) -> o1.getAnnotation(PostType.class).order() - o2.getAnnotation(PostType.class).order()));

            // 按顺序注册
            for (Class<?> c : list) {
                EventHandler.regist(c.getAnnotation(PostType.class).value().name(), c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
