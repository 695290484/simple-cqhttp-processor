package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 *修改群头像
 *group_id	int64	群号
 * file	string	图片文件名
 * cache	int	表示是否使用已缓存的文件
 *
 * 绝对路径, 例如 file:///C:\\Users\Richard\Pictures\1.png, 格式使用 file URI
 * 网络 URL, 例如 http://i1.piimg.com/567571/fdd6e7b6d93f1ef0.jpg
 * Base64 编码, 例如 base64://iVBORw0KGgoAAAANSUhEUgAAABQAAAAVCAIAAADJt1n/AAAAKElEQVQ4EWPk5+RmIBcwkasRpG9UM4mhNxpgowFGMARGEwnBIEJVAAAdBgBNAZf+QAAAAABJRU5ErkJggg==
 * [2] cache参数: 通过网络 URL 发送时有效, 1表示使用缓存, 0关闭关闭缓存, 默认 为1
 *
 * [3] 目前这个API在登录一段时间后因cookie失效而失效, 请考虑后使用
 */

public class SetGroupPortrait  extends BaseAPI {
    public  long group_id;
    public  String file;
    public  int cache;
}
