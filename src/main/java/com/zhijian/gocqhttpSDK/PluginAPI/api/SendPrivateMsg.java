package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 发送私聊消息
终结点：/send_private_msg

user_id	int64	-	对方 QQ 号
group_id	int64	-	主动发起临时会话群号(机器人本身必须是管理员/群主)
message	message	-	要发送的内容
auto_escape	boolean	false	消息内容是否作为纯文本发送 ( 即不解析 CQ 码 ) , 只在 message 字段是字符串时有效
 */

public class SendPrivateMsg extends BaseAPI {
    public long user_id;
    public long group_id;
    public String message;
    public boolean auto_escape;
}