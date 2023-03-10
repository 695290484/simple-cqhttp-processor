package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 对事件执行快速操作 ( 隐藏 API )
注意

隐藏 API 是不建议一般用户使用的, 它们只应该在 OneBot 实现内部或由 SDK 和框架使用, 因为不正确的使用可能造成程序运行不正常。

终结点：/.handle_quick_operation

关于事件的快速操作, 见 快速操作。

参数

字段名	数据类型	默认值	说明
context	object	-	事件数据对象, 可做精简, 如去掉 message 等无用字段
operation	object	-	快速操作对象, 例如{"ban": true, "reply": "请不要说脏话"}
 */

public class HandleQuickOperation extends BaseAPI {
    public Object context;
    public Object operation;
    
}