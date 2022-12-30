package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 重载事件过滤器
终结点：/reload_event_filter

参数

字段名	数据类型	默认值	说明
file	string	-	事件过滤器文件
 */

public class ReloadEventFilter extends BaseAPI {
    public String file;
    
}