package com.lizhen.springboot.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * 消费者
 * Created by lizhen on 2018/4/8 0008.
 */

@Component
public class Consumer {
    private int count = 0;
//防止项目启动报错暂时注释
//    @JmsListener(destination = "${queue}")
    public void receive(TextMessage textMessage, Session session) {
        try {
            String text = textMessage.getText();

            System.out.println("消费端接受到生长者消息: " + text + " 第几次获取消息 count:" + (++count));
            int i = 1 / 0;
            //伪代码耗时15秒
//			Thread.sleep(15000l);
            //获取全局id，主要解决MQ重试机制，避免重复消费的问题
            String jmsMessageID = textMessage.getJMSMessageID();
            //获取消息的日期戳，每次消息的日期戳都不同
            long jmsTimestamp = textMessage.getJMSTimestamp();
            //网络延迟情况下，第二次消费过来，应该使用全局ID该消息是否被消费。
//			if(jmsMessageID==缓存里面){
            //表示手动进行签收。
//				textMessage.acknowledge();// 避免第三次重试。
//			}
            // 消費成功
            //jmsMessageID==存放在緩存裡面


        } catch (Exception e) {
            // 在 catch 日志记录消息报文，可以采用补偿机制 （使用人工补偿），使用定时JOB健康检查脏数据。
//			session.recover();// 重试。
        }
    }


}

