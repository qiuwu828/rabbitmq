package com.example.rabbitmq;

import com.example.rabbitmq.config.MQProvider;
import com.example.rabbitmq.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Date;

@SpringBootTest
class RabbitmqApplicationTests {
    @Autowired
    private MQProvider provider;

    @Test
    public void test() {
        provider.send("hello world");
    }

    @Test
    public void test2() {
        provider.send("queue2", "hello world");
    }

    @Test
    public void test3() {
        provider.send("hunter.direct", "email", "hello world, 你好");
    }

    @Test
    public void test4() {
        provider.send("amq.fanout", "", "hello world, 你好");
    }

    @Test
    public void test5() {
        Book book = new Book(61, "西游记", 100.0, new Date(), "罗贯中", 2);
        provider.send("amq.fanout", "email", book);
    }


//    @Test
//    void contextLoads() {
//
//    }

}
