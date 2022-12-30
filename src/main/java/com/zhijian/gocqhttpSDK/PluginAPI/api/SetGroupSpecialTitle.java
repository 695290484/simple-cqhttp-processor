package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 设置群组专属头衔
终结点：/set_group_special_title

参.

字段名	数据类型	默认值	说明
group_id	int64	-	群号
user_id	int64	-	要设置的 QQ 号
special_title	string	空	专属头衔, 不填或空字符串表示删除专属头衔
duration	number	-1	专属头衔有效期, 单位秒, -1 表示永久, 不过此项似乎没有效果, 可能是只有某些特殊的时间长度有效, 有待测试 */

public class SetGroupSpecialTitle extends BaseAPI {
    public long group_id;
    public long user_id;
    public String special_title;
    public Number duration;
}