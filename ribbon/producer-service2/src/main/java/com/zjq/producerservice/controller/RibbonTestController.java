package com.zjq.producerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>测试ribbon</p>
 *
 * @Author zjq
 * @Date 2021/11/17
 */
@RestController
@RequestMapping(value = "ribbon")
public class RibbonTestController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello, I'm service222";
    }

}
