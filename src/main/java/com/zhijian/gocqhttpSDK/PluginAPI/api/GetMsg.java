package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取消息
终结点: /get_msg

参数

字段	类型	说明
message_id	int32	消息id
 */

public class GetMsg extends BaseAPI {
    public int message_id;
    
}