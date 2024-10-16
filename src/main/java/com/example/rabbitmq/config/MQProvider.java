package com.example.rabbitmq.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 丘戊
 * @package com.example.rabbitmq.config
 * @title 注册发布者
 * @date 19/4/2022 下午 3:43
 */
@Component
public class MQProvider {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg) {
        //使用默认exchange发送
//        rabbitTemplate.convertAndSend("queue1",msg);
//        System.out.println("生产者发送消息："+msg);
        send("", "hello1", msg);
    }

    public void send(String queueName, String msg) {
        //使用默认exchange发送
//        rabbitTemplate.convertAndSend(queueName, msg);
//        System.out.println("生产者发送消息："+msg);
        send("", queueName, msg);
    }

//    public void send(String exchange, String routingKey, String msg){
//        //使用指定exchange发送, 对象被默认序列化之后发送出去
//        rabbitTemplate.convertAndSend(exchange, routingKey, msg);
//        System.out.println("生产者发送消息："+msg);
//    }

    public void send(String exchange, String routingKey, Object msg) {
        //使用指定exchange发送, 对象被默认序列化之后发送出去
        rabbitTemplate.convertAndSend(exchange, routingKey, msg);
        System.out.println("生产者发送消息：" + msg);
    }

}
