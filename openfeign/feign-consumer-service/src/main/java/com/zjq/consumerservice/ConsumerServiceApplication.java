package com.zjq.consumerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <p>消费者服务</p>
 *
 * @EnableFeignClients ：启用OpenFeign
 *
 * @Author zjq
 * @Date 2021/11/17
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class,args);
    }
}
