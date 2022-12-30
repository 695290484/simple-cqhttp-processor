package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 图片 OCR
注意

目前图片OCR接口仅支持接受的图片

ocr_image API移除了实验模式, 目前版本 .ocr_image 和 ocr_image 均能访问, 后期将只保留后者.

go-cqhttp-v0.9.34更新日志

终结点: /ocr_image或/.ocr_image

参数

字段	类型	说明
image	string	图片ID
 */

public class OcrImage extends BaseAPI {
    public String image;
    
}