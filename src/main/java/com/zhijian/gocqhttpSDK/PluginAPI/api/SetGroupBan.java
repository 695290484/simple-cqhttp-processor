package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;



/**
 * 群组单人禁言
终结点：/set_group_ban

参数

字段名	数据类型	默认值	说明
group_id	int64	-	群号
user_id	int64	-	要禁言的 QQ 号
duration	number	30 * 60	禁言时长, 单位秒, 0 表示取消禁言
 */

public class SetGroupBan extends BaseAPI {
    public long group_id;
    public long user_id;
    public int duration;
}