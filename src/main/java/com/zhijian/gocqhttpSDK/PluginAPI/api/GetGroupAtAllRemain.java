package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取群 @全体成员 剩余次数
终结点: /get_group_at_all_remain

参数

字段	类型	说明
group_id	int64	群号
 */

public class GetGroupAtAllRemain extends BaseAPI {
    public long group_id;
    
}