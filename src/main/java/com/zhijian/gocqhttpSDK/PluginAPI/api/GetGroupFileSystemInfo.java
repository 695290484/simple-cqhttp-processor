package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取群文件系统信息
终结点: /get_group_file_system_info

参数

字段	类型	说明
group_id	int64	群号
 */

public class GetGroupFileSystemInfo extends BaseAPI {
    public long group_id;
    
}