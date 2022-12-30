package com.zhijian.gocqhttpSDK.Component;

import com.alibaba.fastjson.JSON;

public class BaseAPI {
    private String addr;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }


}
