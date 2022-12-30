package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;



/**
 * 上传群文件
终结点: /upload_group_file

参数

字段	类型	说明
group_id	int64	群号
file	string	本地文件路径
name	string	储存名称
folder	string	父目录ID
 */

public class UploadGroupFile extends BaseAPI {
    public long group_id;
    public String file;
    public String name;
    public String folder;
}