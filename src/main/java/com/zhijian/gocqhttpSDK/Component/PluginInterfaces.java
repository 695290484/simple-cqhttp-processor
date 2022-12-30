package com.zhijian.gocqhttpSDK.Component;

import com.alibaba.fastjson.JSONObject;

public class PluginInterfaces {
    // 返回值
    public enum RETURN_PLUGIN{
        IGNORED, // 不中断后续的处理器
        HANDLED // 中断后续处理
    };

    public RETURN_PLUGIN handle(JSONObject jsonParam){
        return RETURN_PLUGIN.IGNORED;
    }
}
