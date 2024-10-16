package com.example.rabbitmq.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 丘戊
 * @package com.example.rabbitmq.config
 * @title 注册消费者
 * @date 19/4/2022 下午 3:58
 */
@Component
public class MQReceiver {
    /**
     * 注意： @RabbitListener监听消息, @RabbitHandler 处理消息，两个注解一起使用
     */
    @RabbitHandler
    @RabbitListener(queues = "queue1")
    public void process(Message msg){
        System.out.println("消费者接收queue1消息========>" + new String(msg.getBody()));
        System.out.println(msg.getClass());

    }

    @RabbitHandler
    @RabbitListener(queues = "queue2")
    public void process2(@Payload Object body, @Headers Map<String,Object> headers){
        System.out.println("消费者接收queue2消息========>" + body);
        System.out.println("消息头" + body);
    }

    @RabbitHandler
    @RabbitListener(queues = "queue3")
    public void process3(@Payload Object body){
        System.out.println("消费者接收queue3消息========>" + body);
    }

}
