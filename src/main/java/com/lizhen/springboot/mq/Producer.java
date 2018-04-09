package com.lizhen.springboot.mq;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * Created by Administrator on 2018/4/8 0008.
 */

@Component
//@EnableScheduling
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;

    /**
     * 开启定时任务
     */
//    @Scheduled(fixedDelay = 3000)
    public void send() {
        String reuslt = System.currentTimeMillis() + "---测试消息";
        System.out.println("reuslt:" + reuslt);
        jmsMessagingTemplate.convertAndSend(queue, reuslt);
    }
}
