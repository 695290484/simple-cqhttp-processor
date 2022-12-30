package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * delay	number	0	要延迟的毫秒数, 如果默认情况下无法重启, 可以尝试设置延迟为 2000 左右
 */

public class SetRestart  extends BaseAPI {
    public long number;
}
