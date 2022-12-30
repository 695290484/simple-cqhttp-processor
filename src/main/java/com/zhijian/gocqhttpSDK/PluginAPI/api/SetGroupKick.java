package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 群组踢人
终结点：/set_group_kick

参数

字段名	数据类型	默认值	说明
group_id	int64	-	群号
user_id	int64	-	要踢的 QQ 号
reject_add_request	boolean	false	拒绝此人的加群请求
 */

public class SetGroupKick extends BaseAPI {
    public long group_id;
    public long user_id;
    public boolean reject_add_request;
}