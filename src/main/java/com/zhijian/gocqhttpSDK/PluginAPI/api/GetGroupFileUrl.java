package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取群文件资源链接
提示

File 和 Folder 对象信息请参考最下方

终结点: /get_group_file_url

参数

字段	类型	说明
group_id	int64	群号
file_id	string	文件ID 参考 File 对象
busid	int32	文件类型 参考 File 对象
 */

public class GetGroupFileUrl extends BaseAPI {
    public long group_id;
    public String file_id;
    public int busid;
}