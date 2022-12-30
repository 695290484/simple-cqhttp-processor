package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;



/**
 * 撤回消息
终结点：/delete_msg

参数

字段名	数据类型	默认值	说明
message_id	int32	-	消息 ID
 */

public class DeleteMsg extends BaseAPI {
    public int message_id;
    
}