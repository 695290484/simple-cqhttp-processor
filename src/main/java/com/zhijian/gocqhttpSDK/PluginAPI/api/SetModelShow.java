package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 设置在线机型
提示

有关例子可从这个链接找到

终结点：/_set_model_show

参数

字段	类型	说明
model	string	机型名称
model_show	string	-
 */

public class SetModelShow extends BaseAPI {
    public String model;
    public String  model_show;
    
}