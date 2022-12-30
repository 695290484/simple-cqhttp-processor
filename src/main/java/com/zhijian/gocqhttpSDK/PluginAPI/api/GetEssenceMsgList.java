package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取精华消息列表
终结点: /get_essence_msg_list

参数

字段	类型	说明
group_id	int64	群号
*/

public class GetEssenceMsgList extends BaseAPI {
    public long group_id;
    
}