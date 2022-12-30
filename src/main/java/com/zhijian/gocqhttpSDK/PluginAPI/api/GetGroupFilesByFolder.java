package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取群子目录文件列表
提示

File 和 Folder 对象信息请参考最下方

终结点: /get_group_files_by_folder

参数

字段	类型	说明
group_id	int64	群号
folder_id	string	文件夹ID 参考 Folder 对象
 */

public class GetGroupFilesByFolder extends BaseAPI {
    public long group_id;
    public String folder_id;
    
}