package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;



/**
 * 移出精华消息
终结点: /delete_essence_msg

参数

字段	类型	说明
message_id	int32	消息ID
 */

public class DeleteEssenceMsg extends BaseAPI {
    public int message_id;
    
}