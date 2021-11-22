package com.zjq.sentinelservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>测试controller</p>
 *
 * @Author zjq
 * @Date 2021/11/17
 */
@RestController
@RequestMapping(value = "hello")
public class HelloWorldController {

    private Logger log = LoggerFactory.getLogger(HelloWorldController.class);


    @GetMapping(value = "/testLimit")
    public String hello(@RequestParam(value = "username",required = false,defaultValue = "詹先生") String username){

        return "hello "+username+", I'm sentinel service,follow me,go go go.";
    }

}
