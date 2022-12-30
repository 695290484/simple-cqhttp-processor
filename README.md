# SimpleCQHttpProcessor

#### 介绍
配合 go-cqhttp 使用的 简易消息处理端

#### 配置
1. 设置本服务端口和go-cqhttp服务地址
修改src\main\resources\application.properties
```
server.port=5751
cqhttp.url=http://127.0.0.1:5750/
```

2. 编写消息处理的代码

3. 启动

4. 开发需要注意的问题收集
```
1. 获取json中的数值时先get()后调用toString()，或者用getBigInteger()而不是getInteger()或getLong()等，因为fastJSON会根据数值大小转成不同类型
```
---

##### 有空再补完整readme文件=-=