package com.lizhen.springboot.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * spring-boot封装redis
 * Created by lizhen on 2018/4/2.
 */
@Service
public class PackageRedis {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private ValueOperations<String, String> stringStringValueOperations ;
    private ListOperations<String, String> stringStringListOperations ;

    public void setString(String key, Object value) {
        this.setObject(key, value, null);
    }

    public void setString(String key, Object value, Long time) {
        this.setObject(key, value, time);
    }

    public void setList(String key, Object value) {
        this.setObject(key, value, null);
    }

    public void setList(String key, Object value, Long time) {
        this.setObject(key, value, time);
    }

    public void setObject(String key, Object value, Long time) {
        stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringListOperations = stringRedisTemplate.opsForList();
        if (null == key || null == value) {
            return;
        }
        if (value instanceof String) {
            String valuename = (String) value;

            if (null != time) {
                stringStringValueOperations.set(key, valuename, time);
                return;
            }
            stringStringValueOperations.set(key, valuename);
            return;
        }
        if (value instanceof List) {
            List<String> list = (List) value;

            if (null != time) {
                for (String listname : list) {
                    stringStringListOperations.leftPush(key, listname, String.valueOf(time));
                }
                return;
            }
            for (String listname : list) {
                stringStringListOperations.leftPush(key, listname);
            }
            return;
        }
    }

    public String getStringValue(String key) {
        stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringListOperations = stringRedisTemplate.opsForList();
        String s = stringStringValueOperations.get(key);
        return s;
    }
}
