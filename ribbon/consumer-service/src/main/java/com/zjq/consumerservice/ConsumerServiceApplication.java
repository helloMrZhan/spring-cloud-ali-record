package com.zjq.consumerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <p>消费者服务</p>
 *
 * @Author zjq
 * @Date 2021/11/17
 */
@SpringBootApplication
public class ConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class,args);
    }

    /**
     *   在应用启动时声明并创建RestTemplate对象，其BeanId为restTemplate
     *   @LoadBalanced 使RestTemplate对象自动支持Ribbon负载均衡(如果配置了这个自动负载均衡原先的代码方式请求会报错。)
     */
    @Bean
    //@LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
