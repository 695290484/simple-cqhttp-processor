package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取陌生人信息
终结点：/get_stranger_info

参数

字段名	数据类型	默认值	说明
user_id	int64	-	QQ 号
no_cache	boolean	false	是否不使用缓存（使用缓存可能更新不及时, 但响应更快）
 */

public class GetStrangerInfo extends BaseAPI {
    public long user_id;
    public Boolean no_cache;
}