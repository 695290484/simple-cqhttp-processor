package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 处理加群请求／邀请
终结点：/set_group_add_request

参数

字段名	数据类型	默认值	说明
flag	string	-	加群请求的 flag（需从上报的数据中获得）
sub_type 或 type	string	-	add 或 invite, 请求类型（需要和上报消息中的 sub_type 字段相符）
approve	boolean	true	是否同意请求／邀请
reason	string	空	拒绝理由（仅在拒绝时有效）
 */

public class SetGroupAddRequest extends BaseAPI {
    public String flag;
    public Boolean approve;
    public String reason;
    
}