package com.zjq.bservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * b服务
 * @author zjq
 */
@SpringBootApplication
@EnableFeignClients
public class BServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BServiceApplication.class, args);
    }

}
