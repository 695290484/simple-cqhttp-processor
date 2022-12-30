package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取群成员列表
终结点：/get_group_member_list

参数

字段名	数据类型	默认值	说明
group_id	int64	-	群号
 */

public class GetGroupMemberList extends BaseAPI {
    public long group_id;
    
}