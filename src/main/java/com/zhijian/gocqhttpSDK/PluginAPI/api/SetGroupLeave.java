package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 退出群组
终结点：/set_group_leave

参数

字段名	数据类型	默认值	说明
group_id	int64	-	群号
is_dismiss	boolean	false	是否解散, 如果登录号是群主, 则仅在此项为 true 时能够解散
 */

public class SetGroupLeave extends BaseAPI {
    public long group_id;
    public Boolean is_dismiss;
}  