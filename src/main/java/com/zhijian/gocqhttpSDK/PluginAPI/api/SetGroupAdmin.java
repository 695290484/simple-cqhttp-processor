package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;
/**
 * 群组设置管理员
终结点：/set_group_admin

参数

字段名	数据类型	默认值	说明
group_id	int64	-	群号
user_id	int64	-	要设置管理员的 QQ 号
enable	boolean	true	true 为设置, false 为取消
 */
public class SetGroupAdmin extends BaseAPI {
    public long group_id;
    public long user_id;
    public boolean enable;
}