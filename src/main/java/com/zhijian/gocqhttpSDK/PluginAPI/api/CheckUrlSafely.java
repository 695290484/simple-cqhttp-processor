package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;

/**
 * 检查链接安全性
终结点：/check_url_safely

参数

字段	类型	说明
url	string	需要检查的链接
 */

public class CheckUrlSafely extends BaseAPI {
    public String url;
}