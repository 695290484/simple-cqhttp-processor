package com.zhijian.gocqhttpSDK.Component;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class EventDataHandler {

    public void Handle(JSONObject jsonParam){
        Map<String, List<PluginInterfaces>> map = EventHandler.listHandlers;

        String postType = jsonParam.get("post_type").toString();
        if(postType == null)
            return;

        List<PluginInterfaces> interfaceList = map.get(postType);
        if(interfaceList == null)
            return;

        for (PluginInterfaces inter: interfaceList){
            if(PluginInterfaces.RETURN_PLUGIN.HANDLED == inter.handle(jsonParam))
                break;
        }
    }
}
