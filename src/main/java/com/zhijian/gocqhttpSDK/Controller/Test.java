package com.zhijian.gocqhttpSDK.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Test {
    @GetMapping("/")
    @ResponseBody
    public Map<String,Object> index(){
        Map<String,Object> r = new HashMap<>();
        r.put("result", "running");
        return r;
    }

}
