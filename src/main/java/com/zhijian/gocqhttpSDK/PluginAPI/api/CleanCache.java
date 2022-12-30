package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;



/**
 * group_id	int64	群号
 * file	string	图片文件名
 * cache	int	表示是否使用已缓存的文件
 */

public class CleanCache extends BaseAPI {
    public long group_id	;//int64	群号
    public String file;//	string	图片文件名
    public int cache;//	int	表示是否使用已缓存的文件


}
