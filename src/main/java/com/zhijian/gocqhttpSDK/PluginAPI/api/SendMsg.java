package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 
 * 发送消息
终结点：/send_msg

参数
字段名	数据类型	默认值	说明
message_type	string	-	消息类型, 支持 private、group , 分别对应私聊、群组, 如不传入, 则根据传入的 *_id 参数判断
user_id	int64	-	对方 QQ 号 ( 消息类型为 private 时需要 )
group_id	int64	-	群号 ( 消息类型为 group 时需要 )
message	message	-	要发送的内容
auto_escape	boolean	false	消息内容是否作为纯文本发送 ( 即不解析 CQ 码 ) , 只在 message 字段是字符串时有效
 */

public class SendMsg extends BaseAPI {
    public String message_type;
    public long user_id;
    public long group_id;
    public String message;
    public boolean auto_escape;
}