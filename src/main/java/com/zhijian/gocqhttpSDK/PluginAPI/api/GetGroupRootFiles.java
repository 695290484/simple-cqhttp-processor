package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 *获取群根目录文件列表
提示

File 和 Folder 对象信息请参考最下方

终结点: /get_group_root_files

参数

字段	类型	说明
group_id	int64	群号
 */

public class GetGroupRootFiles extends BaseAPI {
    public long group_id;
    
}