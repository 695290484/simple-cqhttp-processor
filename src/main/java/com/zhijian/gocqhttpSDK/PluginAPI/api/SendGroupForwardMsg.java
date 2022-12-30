package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 
 * 发送消息
终结点：/send_msg

参数
字段名	数据类型	默认值	说明
message_type	string	-	消息类型, 支持 private、group , 分别对应私聊、群组, 如不传入, 则根据传入的 *_id 参数判断
message	message	-	要发送的内容

     id	int32	转发消息id	直接引用他人的消息合并转发, 实际查看顺序为原消息发送顺序 与下面的自定义消息二选一
     name	string	发送者显示名字	用于自定义消息 (自定义消息并合并转发, 实际查看顺序为自定义消息段顺序)
     uin	int64	发送者QQ号	用于自定义消息
     content	message	具体消息	用于自定义消息 不支持转发套娃
     seq	message	具体消息	用于自定义消息
 */

public class SendGroupForwardMsg extends BaseAPI {
    public int group_id;
    public Node message;
    
    class Node  {
        public int id;
        public String name;
        public long uin;
        public String content;
        public String message;

    }
}