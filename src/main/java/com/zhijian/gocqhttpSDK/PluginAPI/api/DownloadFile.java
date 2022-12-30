package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;



/**
 * 下载文件到缓存目录
终结点: /download_file

参数

字段	类型	说明
url	string	链接地址
thread_count	int32	下载线程数
headers	string or array	自定义请求头
 */

public class DownloadFile extends BaseAPI {
    public String url;
    public int thread_count;
    public String headers;
}