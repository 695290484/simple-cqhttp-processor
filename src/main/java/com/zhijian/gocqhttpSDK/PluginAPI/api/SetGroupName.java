package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;

/**
 * 设置群名
终结点：/set_group_name

参数

字段名	数据类型	说明
group_id	int64	群号
group_name	string	新群名
 */

public class SetGroupName extends BaseAPI {
    public long group_id;
    public String group_name;
    
}
