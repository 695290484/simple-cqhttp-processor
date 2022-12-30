package com.zhijian.gocqhttpSDK.Plugins;

import com.alibaba.fastjson.JSONObject;
import com.zhijian.gocqhttpSDK.Annotation.PT;
import com.zhijian.gocqhttpSDK.Annotation.PostType;
import com.zhijian.gocqhttpSDK.Component.PluginInterfaces;
import org.springframework.stereotype.Component;

/**
 * 消息上报(群聊消息)
 * 参考 https://docs.go-cqhttp.org/event/#%E6%B6%88%E6%81%AF%E4%B8%8A%E6%8A%A5
 */

@Component
@PostType(PT.message)
public class GroupMessage extends PluginInterfaces {
    @Override
    public RETURN_PLUGIN handle(JSONObject jsonParam) {
        // 获取消息类型
        String msgType = jsonParam.get("message_type").toString();

        // 如果不是群聊消息则跳过处理
        if(null == msgType || !"group".equals(msgType))
            return RETURN_PLUGIN.IGNORED;

        // 获取发送者信息
        JSONObject sender = jsonParam.getJSONObject("sender");
        System.out.println("来自群("+jsonParam.get("group_id")+")"+sender.get("nickname").toString() + "(" + sender.get("user_id").toString() + ")" + ": " + jsonParam.get("raw_message").toString());

        return RETURN_PLUGIN.IGNORED;
    }
}
