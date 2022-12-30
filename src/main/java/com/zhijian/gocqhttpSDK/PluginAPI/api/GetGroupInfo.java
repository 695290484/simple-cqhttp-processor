package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取群信息
终结点：/get_group_info

参数

字段名	数据类型	默认值	说明
group_id	int64	-	群号
no_cache	boolean	false	是否不使用缓存（使用缓存可能更新不及时, 但响应更快）
 */

public class GetGroupInfo extends BaseAPI {
    public long group_id;
    public Boolean no_cache;
}