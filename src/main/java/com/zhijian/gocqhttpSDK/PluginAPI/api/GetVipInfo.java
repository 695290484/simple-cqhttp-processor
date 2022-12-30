package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取VIP信息
终结点：/_get_vip_info

参数

字段名	数据类型	默认值	说明
user_id	int64		QQ 号
 */

public class GetVipInfo extends BaseAPI {
    public long user_id;
    
}