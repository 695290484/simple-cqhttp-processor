package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;

/**
 * 群组匿名
注意

该 API 暂未被 go-cqhttp 支持, 您可以提交 pr 以使该 API 被支持 提交 pr

终结点：/set_group_anonymous

参数

字段名	数据类型	默认值	说明
group_id	int64	-	群号
enable	boolean	true	是否允许匿名聊天
 */

public class SetGroupAnonymous extends BaseAPI {
    public long group_id;
    public Boolean enable;
    
}