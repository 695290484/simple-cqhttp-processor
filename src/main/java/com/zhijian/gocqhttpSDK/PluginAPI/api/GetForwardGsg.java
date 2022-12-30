package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取合并转发内容
终结点: /get_forward_msg

参数

字段	类型	说明
message_id	string	消息id
 */

public class GetForwardGsg extends BaseAPI {
    public String message_id;
    
}