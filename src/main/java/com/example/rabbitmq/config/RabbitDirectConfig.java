package com.example.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 丘戊
 * @package com.example.rabbitmq.config
 * @title 注册交换机Exchange、队列Queue和Binding
 * @date 19/4/2022 下午 2:57
 */
@Configuration
public class RabbitDirectConfig {
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue queue1() {
        return new Queue("queue1");
    }

    @Bean
    public Queue queue2() {
        return new Queue("queue2");
    }

    @Bean
    public Queue queue3() {
        return new Queue("queue3");
    }

    //    点对点交换机
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange", true, false);
    }

    //    广播交换机
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("amq.fanout", true, false);
    }

    //    点对点交换机配置
    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(directExchange()).with("email");
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(directExchange()).with("sms");
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(queue3()).to(directExchange()).with("weixin");
    }

    //    广播交换机配置
    @Bean
    Binding fanoutBinding1() {
        return BindingBuilder.bind(queue1()).to(fanoutExchange());
    }

    @Bean
    Binding fanoutBinding2() {
        return BindingBuilder.bind(queue2()).to(fanoutExchange());
    }

    @Bean
    Binding fanoutBinding3() {
        return BindingBuilder.bind(queue3()).to(fanoutExchange());
    }
}
