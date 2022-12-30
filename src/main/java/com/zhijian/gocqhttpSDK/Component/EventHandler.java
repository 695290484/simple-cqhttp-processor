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
    static Map<String, List<PluginInterfaces>> listHandlers = new HashMap<>();

    // 注册处理器
    public static void regist(String post_type, Class chh){
        List<PluginInterfaces> list = listHandlers.get(post_type);
        if(list == null)
            list = new ArrayList<>();

        Object obj = ApplicationContextProvider.getBean(chh);
        if(obj != null) {
            if (obj instanceof PluginInterfaces) {
                list.add((PluginInterfaces) obj);
                listHandlers.put(post_type, list);
            }
            else
                log.error("注册失败,事件处理器 {} 没有继承 {}", chh.getName(), PluginInterfaces.class.getName());
        }else{
            log.error("注册失败,事件处理器 {} 没有交给Spring管理", chh.getName());
        }
    }
}
