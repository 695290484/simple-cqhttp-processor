package com.zhijian.gocqhttpSDK.Plugins;

import com.alibaba.fastjson.JSONObject;
import com.zhijian.gocqhttpSDK.Annotation.PT;
import com.zhijian.gocqhttpSDK.Annotation.PostType;
import com.zhijian.gocqhttpSDK.Component.PluginInterfaces;
import org.springframework.stereotype.Component;

/**
 * 元事件上报
 * 参考 https://docs.go-cqhttp.org/event/#%E9%80%9A%E7%94%A8%E6%95%B0%E6%8D%AE
 */

@Component
@PostType(PT.meta_event)
public class MetaEvent extends PluginInterfaces {
    @Override
    public RETURN_PLUGIN handle(JSONObject jsonParam) {
        //System.out.println(jsonParam.toJSONString());
        return RETURN_PLUGIN.IGNORED;
    }
}
