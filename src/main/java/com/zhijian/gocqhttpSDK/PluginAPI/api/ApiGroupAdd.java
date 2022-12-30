package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;

/**
 * 添加组
 */

public class ApiGroupAdd extends BaseAPI {
    public String flag;
    public String sub_type;
    public String type;
    public boolean approve;
    public String reason;// 拒绝理由（仅在拒绝时有效）
}
