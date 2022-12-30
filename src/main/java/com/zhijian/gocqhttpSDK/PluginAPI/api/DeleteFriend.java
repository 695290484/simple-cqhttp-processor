package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;



/**
 * 删除好友
终结点：/delete_friend

参数

字段名	数据类型	默认值	说明
friend_id	int64	-	好友 QQ 号
 */

public class DeleteFriend extends BaseAPI {
    public long friend_id;
    
}