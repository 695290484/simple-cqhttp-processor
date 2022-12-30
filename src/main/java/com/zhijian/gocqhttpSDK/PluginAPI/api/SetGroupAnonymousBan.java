package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;



/**
 * 群组匿名用户禁言
注意

该 API 从 go-cqhttp-v0.9.36 开始支持

终结点：/set_group_anonymous_ban

参数

字段名	数据类型	默认值	说明
group_id	int64	-	群号
anonymous	object	-	可选, 要禁言的匿名用户对象（群消息上报的 anonymous 字段）
anonymous_flag 或 flag	string	-	可选, 要禁言的匿名用户的 flag（需从群消息上报的数据中获得）
duration	number	30 * 60	禁言时长, 单位秒, 无法取消匿名用户禁言
 */

public class SetGroupAnonymousBan extends BaseAPI {
    public long group_id;
    public String anonymous;
    public String anonymous_flag;
    public int  duration;
}