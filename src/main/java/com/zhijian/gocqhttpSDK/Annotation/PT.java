package com.zhijian.gocqhttpSDK.Annotation;

public enum PT {
    message("message"),
    message_sent("message_sent"),
    request("request"),
    notice("notice"),
    meta_event("meta_event");

    String tname;
    PT(String tname){
        this.tname = tname;
    };

}
