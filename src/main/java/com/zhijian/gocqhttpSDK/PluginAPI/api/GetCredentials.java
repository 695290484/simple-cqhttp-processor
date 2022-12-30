package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取 QQ 相关接口凭证
注意

该 API 暂未被 go-cqhttp 支持, 您可以提交 pr 以使该 API 被支持 提交 pr

提示

即上面两个接口的合并

终结点：/get_credentials

参数

字段名	数据类型	默认值	说明
domain	string	空	需要获取 cookies 的域名
 */

public class GetCredentials extends BaseAPI {
    public String domain;
    
}