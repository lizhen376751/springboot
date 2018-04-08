package com.lizhen.springboot.redis.controller;

import com.lizhen.springboot.redis.service.PackageRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhen on 2018/4/2.
 */
@RestController
public class IndexController {
    @Autowired
    private PackageRedis packageRedis;
    @RequestMapping("/setString")
    public String set(String key,String value){
        packageRedis.setString(key,value);
        return "sucess";
    }
    @RequestMapping("/getString")
    public String getKey(String key){
        String stringValue = packageRedis.getStringValue(key);
        return stringValue;
    }
}
