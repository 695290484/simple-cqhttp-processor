# SimpleCQHttpProcessor

>### 简介
配合 go-cqhttp 使用的 简易消息处理端（QQ机器人）

使用JAVA编写，支持插件式开发，方便感兴趣的朋友们一起开发和拓展。

>### I. 准备工作
1. 安装JAVA运行环境(version 1.8)：[官网下载](https://www.oracle.com/java/technologies/downloads/#java8-windows) 

2. 安装GO-CQHTTP：[官方下载](https://github.com/Mrs4s/go-cqhttp/releases) | [官方文档](https://docs.go-cqhttp.org/)

3. 下载本项目：[发行版](https://gitee.com/q695290484/simple-cqhttp-processor/releases/download/Release/gocqhttpSDK-0.0.1-SNAPSHOT.jar)

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

>### IV. 启动本程序
如果你下载的是本程序的源代码，请先了解一下如何使用maven打包成.jar文件。如果已经是.jar文件，只需要打开命令提示符，使用java命令运行即可：
```
java -jar gocqhttpSDK-0.0.1-SNAPSHOT.jar
```

---
>#### 开发需要注意的问题收集
```
1. 获取事件上报数据的json中的数值时先get()后调用toString()，或者用getBigInteger()而不是getInteger()或getLong()等，因为fastJSON会根据数值大小转成不同类型，固定死了反而会报错。

2. 关于go-cqhttp上报的以及API返回的数据格式参考go-cqhttp帮助文档
```



>##### _感谢go-cqhttp的开发者们提供的代码和帮助文档，本项目基于开源协议[AGPL3.0](https://gitee.com/q695290484/simple-cqhttp-processor/blob/master/LICENSE)_