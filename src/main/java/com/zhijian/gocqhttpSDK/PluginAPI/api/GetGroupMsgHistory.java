package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取群消息历史记录
终结点：/get_group_msg_history

参数

字段	类型	说明
message_seq	int64	起始消息序号, 可通过 get_msg 获得
group_id	int64	群号
 */

public class GetGroupMsgHistory extends BaseAPI {
    public long message_seq;
    public long group_id;
    
}