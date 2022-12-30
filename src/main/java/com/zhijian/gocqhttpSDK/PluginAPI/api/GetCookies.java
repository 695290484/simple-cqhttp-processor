package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取 Cookies
注意

该 API 暂未被 go-cqhttp 支持, 您可以提交 pr 以使该 API 被支持 提交 pr

终结点：/get_cookies

参数

字段名	数据类型	默认值	说明
domain	string	空	需要获取 cookies 的域名
 */

public class GetCookies extends BaseAPI {
    public String domain;
    
}