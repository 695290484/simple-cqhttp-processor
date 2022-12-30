package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取图片信息
终结点: /get_image

注意

该接口为 CQHTTP 接口修改

参数

字段	类型	说明
file	string	图片缓存文件名
 */

public class GetImage extends BaseAPI {
    public String file;
}