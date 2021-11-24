package com.zjq.nacosconfigexample.controller;

import com.zjq.nacosconfigexample.config.ZjqConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>测试controller</p>
 *
 * @Author zjq
 * @Date 2021/11/17
 */
@RestController
@RequestMapping(value = "hello")
public class HelloWorldController {

    @Resource
    private ZjqConfig zjqConfig;


    @GetMapping(value = "/zjq")
    public String hello(){
        return "姓名： "+zjqConfig.getName()+", 地址："+zjqConfig.getAddress();
    }

}
