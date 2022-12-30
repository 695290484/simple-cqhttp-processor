package com.zhijian.gocqhttpSDK.PluginAPI.api;
import com.zhijian.gocqhttpSDK.Component.BaseAPI;


/**
 * 获取群荣誉信息
终结点：/get_group_honor_info

参数

字段名	数据类型	默认值	说明
group_id	int64	-	群号
type	string	-	要获取的群荣誉类型, 可传入 talkative performer legend strong_newbie emotion 以分别获取单个类型的群荣誉数据, 或传入 all 获取所有数据
 */

public class GetGroupHonorInfo extends BaseAPI {
    public long group_id;
    public String type;
    
}