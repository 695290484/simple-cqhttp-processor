package com.zhijian.gocqhttpSDK.Utils;

import com.alibaba.fastjson.JSONObject;
import com.zhijian.gocqhttpSDK.Component.QQ;
import com.zhijian.gocqhttpSDK.PluginAPI.API;
import com.zhijian.gocqhttpSDK.PluginAPI.api.SendGroupMsg;
import com.zhijian.gocqhttpSDK.PluginAPI.api.SendPrivateMsg;
import org.springframework.stereotype.Component;

@Component
public class CallerUtil {

    /**
     * 发送群消息
     * @param groupId 群号
     * @param msg 消息内容
     */
    public static String sendGroupMsg(String groupId, String msg){
        SendGroupMsg request = QQ.create(API.SEND_GROUP_MSG);
        request.group_id = Long.parseLong(groupId);
        request.message = msg;
        JSONObject result = QQ.send(request);
        return (result != null)? result.toString(): null;
    }

    /**
     * 发送私人消息
     * @param userId 目标Q号
     * @param msg 消息内容
     */
    public static String sendPrivateMsg(String userId, String msg){
        SendPrivateMsg request = (SendPrivateMsg) QQ.create(API.SEND_PRIVATE_MSG);
        request.user_id = Long.parseLong(userId);;
        request.message = msg;
        JSONObject result = QQ.send(request);
        return (result != null)? result.toString(): null;
    }

    /**
     * CQ码:at某人
     * @param userId 目标Q号
     * @return
     */
    public static String at(String userId){
        return "[CQ:at,qq="+userId+"]";
    }
}
