package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 群组全员禁言
终结点：/set_group_whole_ban

参数

字段名	数据类型	默认值	说明
group_id	int64	-	群号
enable	boolean	true	是否禁言
 */

public class SetgGroupWholeBan extends BaseAPI {
    public long group_id;
    public boolean enable;
}