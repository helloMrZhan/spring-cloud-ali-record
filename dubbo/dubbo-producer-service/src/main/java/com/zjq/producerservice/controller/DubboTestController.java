package com.zjq.producerservice.controller;

import com.zjq.producerservice.dubbo.ProducerService;
import com.zjq.producerservice.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>测试dubbo</p>
 *
 * @Author zjq
 * @Date 2021/11/17
 */
@RestController
@RequestMapping(value = "dubbo")
public class DubboTestController {

    @Resource
    private ProducerService producerService;

    @GetMapping(value = "/hello")
    public String hello(@RequestParam(value = "username",required = false,defaultValue = "詹先生") String username){
        return producerService.hello(username);
    }

    @GetMapping(value = "/getUser")
    public User getUserByName(@RequestParam(value = "username",required = false,defaultValue = "詹先生") String username){
        return producerService.getUserByName(username);
    }

}
