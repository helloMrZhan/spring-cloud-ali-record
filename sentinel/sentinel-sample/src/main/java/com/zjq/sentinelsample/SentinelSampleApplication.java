package com.zjq.sentinelsample;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * <p>Sentinel客户端服务</p>
 *
 *
 * @Author zjq
 * @Date 2021/11/17
 */
@SpringBootApplication
public class SentinelSampleApplication {

    /**
     * 熔断前置检查bean
     * @return
     */
    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

    public static void main(String[] args) {
        SpringApplication.run(SentinelSampleApplication.class,args);
    }
}
