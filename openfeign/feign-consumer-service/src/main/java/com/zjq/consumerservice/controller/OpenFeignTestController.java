package com.zjq.consumerservice.controller;

import com.zjq.consumerservice.entity.User;
import com.zjq.consumerservice.feignclient.ProducerServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>测试OpenFeign</p>
 *
 * @Author zjq
 * @Date 2021/11/17
 */
@RestController
@RequestMapping(value = "feign")
public class OpenFeignTestController {

    private Logger log = LoggerFactory.getLogger(OpenFeignTestController.class);

    @Resource
    private ProducerServiceClient producerServiceClient;

    @GetMapping(value = "/hello")
    public String hello(@RequestParam(value = "username",required = false,defaultValue = "詹先生") String username){

        return producerServiceClient.hello(username);
    }

    @GetMapping(value = "/getUser")
    public User getUserByName(@RequestParam(value = "username",required = false,defaultValue = "詹先生") String username){
        return producerServiceClient.getUserByName(username);

    }
}
