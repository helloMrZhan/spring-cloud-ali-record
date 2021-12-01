package com.zjq.bservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zjq
 */
@FeignClient("c-service")
public interface CServiceFeignClient {
    @GetMapping("/c")
    public String methodC();
}
