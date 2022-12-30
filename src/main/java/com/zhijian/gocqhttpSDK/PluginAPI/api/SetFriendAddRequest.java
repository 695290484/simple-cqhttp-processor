package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;



/**
 * 处理加好友请求
终结点：/set_friend_add_request

参数

字段名	数据类型	默认值	说明
flag	string	-	加好友请求的 flag（需从上报的数据中获得）
approve	boolean	true	是否同意请求
remark	string	空	添加后的好友备注（仅在同意时有效）
 */

public class SetFriendAddRequest extends BaseAPI {
    public String flag;
    public Boolean approve;
    public String remark;
}