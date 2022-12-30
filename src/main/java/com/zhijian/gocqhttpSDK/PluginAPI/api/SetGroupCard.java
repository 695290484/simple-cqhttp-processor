package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;

/**
 * 设置群名片 ( 群备注 )
终结点：/set_group_card

参数

字段名	数据类型	默认值	说明
group_id	int64	-	群号
user_id	int64	-	要设置的 QQ 号
card	string	空	群名片内容, 不填或空字符串表示删除群名片
 */

public class SetGroupCard extends BaseAPI {
    public long group_id;
    public long user_id;
    public String card;
}