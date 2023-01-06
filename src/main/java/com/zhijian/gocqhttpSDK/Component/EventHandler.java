package com.zhijian.gocqhttpSDK.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EventHandler {

    private static final Logger log = LoggerFactory.getLogger(EventHandler.class);

    // 按添加先后注册处理器(post_type -> 请求数据)
    static Map<String, List<PluginInfo>> listHandlers = new HashMap<>();

    // 注册处理器
    public static void regist(PluginInfo pluginInfo){
        List<PluginInfo> list = listHandlers.get(pluginInfo.PostType);
        if(list == null)
            list = new ArrayList<>();

        Object obj = pluginInfo.PluginObject;
        if(obj != null) {
            if(pluginInfo.fromJar == 0) {
                if (obj instanceof PluginInterfaces) {
                    list.add(pluginInfo);
                    listHandlers.put(pluginInfo.PostType, list);
                } else
                    log.error("注册失败,事件处理器 {} 没有继承 {}", pluginInfo.PluginObject.getClass().getName(), PluginInterfaces.class.getName());
            }else{
                list.add(pluginInfo);
                listHandlers.put(pluginInfo.PostType, list);
            }
        }else if(pluginInfo.fromJar == 0){
            log.error("注册失败,事件处理器 {} 没有交给Spring管理", pluginInfo.PluginObject.getClass().getName());
        }
    }
}
