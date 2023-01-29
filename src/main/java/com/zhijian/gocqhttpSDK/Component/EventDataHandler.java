package com.zhijian.gocqhttpSDK.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Component
public class EventDataHandler {

    public void Handle(JSONObject jsonParam){
        Map<String, List<PluginInfo>> map = EventHandler.listHandlers;

        String postType = jsonParam.get("post_type").toString();
        if(postType == null)
            return;

        List<PluginInfo> interfaceList = map.get(postType);
        if(interfaceList == null)
            return;

        for (PluginInfo info: interfaceList){
            Class<?> clazz = info.PluginObject.getClass();

            if(info.paused > 0)
                continue; //暂停状态的插件不调用

            try {
                if(info.fromJar == 0) {
                    Method handle = clazz.getMethod("handle", JSONObject.class);
                    if (PluginInterfaces.RETURN_PLUGIN.HANDLED == handle.invoke(info.PluginObject, jsonParam))
                        break;
                }else{
                    Method handle = clazz.getMethod("handle", String.class);
                    if (1 == (Integer) handle.invoke(info.PluginObject, JSON.toJSONString(jsonParam)))
                        break;
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }
    }
}
