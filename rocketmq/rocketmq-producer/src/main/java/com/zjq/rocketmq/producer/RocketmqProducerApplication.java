package com.zjq.rocketmq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zjq
 * @date 2022/1/3 21:41
 * <p>title:RocketMQ生产者服务</p>
 * <p>description:</p>
 */
@SpringBootApplication
public class RocketmqProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketmqProducerApplication.class,args);
    }
}
