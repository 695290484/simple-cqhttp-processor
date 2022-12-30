package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取当前账号在线客户端列表
终结点：/get_online_clients

参数

字段	类型	说明
no_cache	bool	是否无视缓存
 */

public class GetOnlineClients extends BaseAPI {
    public boolean no_cache;

}