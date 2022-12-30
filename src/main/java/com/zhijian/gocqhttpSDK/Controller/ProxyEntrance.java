package com.zhijian.gocqhttpSDK.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zhijian.gocqhttpSDK.Component.EventDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Controller
@CrossOrigin
public class ProxyEntrance {

    @Autowired
    EventDataHandler eventDataHandler;

    @PostMapping(value = "/entrance")
    public void entrance(HttpServletRequest request){
        JSONObject jsonParam = this.getJSONParam(request);
        eventDataHandler.Handle(jsonParam);
    }

    public JSONObject getJSONParam(HttpServletRequest request){
        JSONObject jsonParam = null;
        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = streamReader.readLine()) != null) {
                sb.append(line);
            }
            jsonParam = JSONObject.parseObject(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonParam;
    }
}
