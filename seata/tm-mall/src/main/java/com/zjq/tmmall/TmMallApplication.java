package com.zjq.tmmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * <p>商城微服务，事务管理者TM</p>
 *
 * @Author zjq
 * @Date 2022/1/7
 */
@SpringBootApplication
//@EnableAutoDataSourceProxy
@EnableFeignClients
public class TmMallApplication {
    public static void main(String[] args) {
        SpringApplication.run(TmMallApplication.class, args);
    }

}
