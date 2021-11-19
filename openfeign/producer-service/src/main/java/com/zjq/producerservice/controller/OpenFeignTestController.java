package com.zjq.producerservice.controller;

import com.zjq.producerservice.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>测试OpenFeign</p>
 *
 * @Author zjq
 * @Date 2021/11/17
 */
@RestController
@RequestMapping(value = "feign")
public class OpenFeignTestController {

    @GetMapping(value = "/hello")
    public String hello(@RequestParam(value = "username",required = false,defaultValue = "詹先生") String username){
        return "hello "+username+", I'm producer service,follow me,go go go.";
    }

    @GetMapping(value = "/getUser")
    public User getUserByName(@RequestParam(value = "username",required = false,defaultValue = "詹先生") String username){
        if("zjq".equals(username)){
            return new User("zjq","123456","HS");
        }else {
            return new User("二狗子","123456","HS");
        }

    }

}
