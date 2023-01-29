## SCQP
>### 插件示例
#### 机器人处理端[插件示例](https://gitee.com/q695290484/SimpleCQHttpProcessor-Samples) ：
* [AIReply](https://gitee.com/q695290484/SimpleCQHttpProcessor-Samples/blob/master/Plugins/AIReply.java)（群自动回复、涩图）
* [GroupMemberAdd](https://gitee.com/q695290484/SimpleCQHttpProcessor-Samples/blob/master/Plugins/GroupMemberAdd.java)（新人入群通知）
* [GroupRequest](https://gitee.com/q695290484/SimpleCQHttpProcessor-Samples/blob/master/Plugins/GroupRequest.java)（加群自动审核） _*貌似没用_
* [Music](https://gitee.com/q695290484/SimpleCQHttpProcessor-Samples/blob/master/Plugins/Music.java)（群点歌） _*搜索+选歌_
* [RollTheDice](https://gitee.com/q695290484/SimpleCQHttpProcessor-Samples/blob/master/Plugins/RollTheDice.java)（群抽奖、抽人）

#### Tips：
`以上为内嵌形式的插件，不定时更新，有些并不能直接使用`   
<br>

>### 基本命令(New* 2023/1/29) (示例)
1. `plugins` 显示当前已加载的插件

Total 3 plugins, 3 running, 0 paused.(使用'pause/unpause 编号'可关开插件)


|编号|类名|插件名|上报类型|顺序|外部插件|状态|
|----|----|----|----|----|----|----|
|  1   |  com.zhijian.gocqhttpSDK.Plugins.MetaEvent   |         | meta_event |  0   |     0      |running|
|  2   |com.zhijian.gocqhttpSDK.Plugins.PrivateMessage|         |  message   |  0   |     0      |running|
|  3   | com.zhijian.gocqhttpSDK.Plugins.GroupMessage |         |  message   |  0   |     0      |running|


2. `pause` 暂停插件
   >示例
   > <br>pause 1   暂停编号为1的插件
   > <br>pause 0   暂停所有插件
3. `unpause` 恢复运行
   >示例
   > <br>unpause 1   恢复编号为1的插件
   > <br>unpause 0   恢复所有插件



<br>

>### 简介
配合 go-cqhttp 使用的 简易消息处理端（QQ机器人）

使用JAVA编写，支持插件式开发，方便感兴趣的朋友们一起开发和拓展。

<br>


>### I. 准备工作
1. 安装JAVA运行环境(version 1.8)：[官网下载](https://www.oracle.com/java/technologies/downloads/#java8-windows) 

2. 安装GO-CQHTTP：[官方下载](https://github.com/Mrs4s/go-cqhttp/releases) | [官方文档](https://docs.go-cqhttp.org/)

3. 下载本项目：[发行版](https://gitee.com/q695290484/simple-cqhttp-processor/releases/download/Release/gocqhttpSDK-0.0.1-SNAPSHOT.jar)
<br><br>

>### II. 配置
1. 使用命令提示符运行go-cqhttp.exe，按提示运行成功后会自动生成配置文件

2. 使用文本工具打开go-cqhttp的配置文件config.yml，注意以下配置要和步骤3对应：
```
servers:
    - http:
        address: 0.0.0.0:5750 # HTTP监听地址
        post:           # 反向HTTP POST地址列表
        - url: http://127.0.0.1:5751/entrance/ # 地址
        max-retries: 0             # 最大重试，建议改为0
```


3. 设置本程序的服务端口：
修改src\main\resources\application.properties
```
# 本处理端的端口
server.port=5751

# go-cqhttp中配置的HTTP监听地址
cqhttp.url=http://127.0.0.1:5750/
```

<br>

>### III. 编写消息处理的代码
1. 在 com.zhijian.gocqhttpSDK.Plugins 包中创建类文件
2. 继承PluginInterfaces并在类上根据[上报类型](https://docs.go-cqhttp.org/reference/data_struct.html#post-type)添加注解，例：
```
@Component
@PostType(PT.notice)
public class GroupMemberAdd extends PluginInterfaces {
    @Override
    public RETURN_PLUGIN handle(JSONObject jsonParam) {
        // 用户加群时会触发这里,因为加群的上报类型为notice
    }
}
```
3. 调用[API接口](https://gitee.com/q695290484/simple-cqhttp-processor/blob/master/src/main/java/com/zhijian/gocqhttpSDK/PluginAPI/API.java)，例：
```
    @Override
    public RETURN_PLUGIN handle(JSONObject jsonParam) {
        // 用户加群时这里会触发,因为加群的上报类型为notice

        // 如果不是入群通知则跳过处理
        if(null == msgType || !"group_increase".equals(msgType))
            return RETURN_PLUGIN.IGNORED;

        // 获取群号
        String group = jsonParam.get("group_id").toString();

        // 获取发送者信息
        Number userId = jsonParam.getBigInteger("user_id");

        // 发送群信息(顺便@了一下新人)
        SendGroupMsg groupmsg = QQ.create(API.SEND_GROUP_MSG);
        groupmsg.group_id = Long.parseLong(groupId);
        groupmsg.message = "欢迎 [CQ:at,qq="+userId+"] 加入我们的群!";
        QQ.send(groupmsg);

        return RETURN_PLUGIN.IGNORED;
    }
```
<br>


>### IV. 启动本程序
如果你下载的是本程序的源代码，请先了解一下如何使用maven打包成.jar文件。如果已经是.jar文件，只需要打开命令提示符，使用java命令运行即可：
```
java -jar gocqhttpSDK-0.0.1-SNAPSHOT.jar
```
<br>

---
>#### 开发需要注意的问题收集
```
1. 获取事件上报数据的json中的数值时先get()后调用toString()，或者用getBigInteger()而不是getInteger()或getLong()等，因为fastJSON会根据数值大小转成不同类型，固定死了反而会报错。

2. 关于go-cqhttp上报的以及API返回的数据格式参考go-cqhttp帮助文档
```

>#### New* 新增对外部Jar包形式的插件支持 2023/01/07
>`支持独立于处理端主程序的插件编写`
>`将插件.jar放入处理端jar文件同目录下的Plugins文件夹即可`
>[示例](https://gitee.com/q695290484/scqhp-plugindemo)

<br> 

>#### 未来计划内容(`随缘=-=`):
> 1. 增加更多的插件示例 
> 2. 增加插件加载、卸载、停用、启用命令

<br> 

---
>##### _感谢go-cqhttp的开发者们提供的代码和帮助文档，本项目基于开源协议[AGPL3.0](https://gitee.com/q695290484/simple-cqhttp-processor/blob/master/LICENSE)_