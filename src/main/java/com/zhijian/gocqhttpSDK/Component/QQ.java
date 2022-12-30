package com.zhijian.gocqhttpSDK.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhijian.gocqhttpSDK.PluginAPI.API;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QQ {

    static String CQHttpUrl;
    static RestTemplateUtil restTemplateUtil;

    @Value("${cqhttp.url}")
    public void setUrl(String url){
        QQ.CQHttpUrl = url;
    }

    @Autowired
    public void setUtil(RestTemplateUtil util){
        QQ.restTemplateUtil = util;
    }

    private static final Logger log = LoggerFactory.getLogger(QQ.class);

    /**
     * 创建API请求对象
     * @param api
     * @param <T>
     * @return
     */
    public static<T extends BaseAPI> T create(API api){
        T obj = null;
        try {
            obj = (T) (api.getClazz().newInstance());
            obj.setAddr(api.getApiAdr());
            obj.setDesc(api.getDescribe());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 发送api请求
     * @param apiObject
     * @return
     */
    public static JSONObject send(BaseAPI apiObject){
        String jsonRequest = apiObject.toString();
        String requestAddr = apiObject.getAddr();

        String response = "";
        try{
            response = restTemplateUtil.post(CQHttpUrl + requestAddr, jsonRequest);
        }catch (Exception e){
            log.error("API[{}] 发送失败,原因是:{}", apiObject.getDesc(), e.getMessage());
        }
        return JSON.parseObject(response);
    }
}
