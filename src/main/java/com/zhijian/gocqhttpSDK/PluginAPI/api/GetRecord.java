package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取语音
注意

该 API 暂未被 go-cqhttp 支持, 您可以提交 pr 以使该 API 被支持 提交 pr

终结点：/get_record

提示

要使用此接口, 通常需要安装 ffmpeg, 请参考 OneBot 实现的相关说明。

参数

字段名	数据类型	默认值	说明
file	string	-	收到的语音文件名（消息段的 file 参数）, 如 0B38145AA44505000B38145AA4450500.silk
out_format	string	-	要转换到的格式, 目前支持 mp3、amr、wma、m4a、spx、ogg、wav、flac
 */

public class GetRecord extends BaseAPI {
    public String file;
    public String out_format;
    
}