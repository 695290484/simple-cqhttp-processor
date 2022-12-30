package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 发送群公告
终结点： /_send_group_notice

参数

字段名	数据类型	默认值	说明
group_id	int64		群号
content	string		公告内容
image	string		图片路径（可选）
 */

public class SendGroupNotice extends BaseAPI {
    public long group_id;
    public String content;
    public String image;
}