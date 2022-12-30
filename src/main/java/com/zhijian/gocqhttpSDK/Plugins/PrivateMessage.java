package com.zhijian.gocqhttpSDK.Plugins;

import com.alibaba.fastjson.JSONObject;
import com.zhijian.gocqhttpSDK.Annotation.PT;
import com.zhijian.gocqhttpSDK.Annotation.PostType;
import com.zhijian.gocqhttpSDK.Component.PluginInterfaces;
import com.zhijian.gocqhttpSDK.PluginAPI.API;
import com.zhijian.gocqhttpSDK.Component.QQ;
import com.zhijian.gocqhttpSDK.PluginAPI.api.SendPrivateMsg;
import org.springframework.stereotype.Component;

/**
 * 消息上报(私聊消息)
 * 参考 https://docs.go-cqhttp.org/event/#%E6%B6%88%E6%81%AF%E4%B8%8A%E6%8A%A5
 */

@Component
@PostType(PT.message)
public class PrivateMessage extends PluginInterfaces {
    @Override
    public RETURN_PLUGIN handle(JSONObject jsonParam) {
        // 获取消息类型
        String msgType = jsonParam.get("message_type").toString();

        // 如果不是私聊消息则跳过处理
        if(null == msgType || !"private".equals(msgType))
            return RETURN_PLUGIN.IGNORED;

        // 获取发送者信息
        JSONObject sender = jsonParam.getJSONObject("sender");
        System.out.println(sender.get("nickname").toString() + "(" + sender.get("user_id").toString() + ")" + ": " + jsonParam.get("raw_message").toString());

        // 使用QQ.create()和QQ.send()来创建请求参数和发送请求
        SendPrivateMsg request = (SendPrivateMsg) QQ.create(API.SEND_PRIVATE_MSG);
        request.user_id = 12345L;
        request.message = sender.get("nickname").toString() + "(" + sender.get("user_id").toString() + ")" + ": " + jsonParam.get("raw_message").toString();
        JSONObject response = QQ.send(request);
        if(response != null)
            System.out.println(response.toJSONString());

        return RETURN_PLUGIN.IGNORED;
    }

}

