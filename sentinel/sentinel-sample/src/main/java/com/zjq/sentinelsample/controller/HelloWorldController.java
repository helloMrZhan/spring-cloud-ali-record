package com.zjq.sentinelsample.controller;

import com.zjq.sentinelsample.service.SampleService;
import com.zjq.sentinelsample.vo.ResponseObject;
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
    private SampleService sampleService;

    /**
     * 测试限流
     * @param username
     * @return
     */
    @GetMapping(value = "/testLimit")
    public String hello(@RequestParam(value = "username",required = false,defaultValue = "詹先生") String username){
        return "hello "+username+", I'm sentinel service,follow me,go go go.";
    }

    /**
     * 测试限流
     * @param username
     * @return
     */
    @GetMapping(value = "/test_degrade_rule")
    public ResponseObject testDegrade(@RequestParam(value = "username",required = false,defaultValue = "詹先生") String username){
        try {
            sampleService.createOrder();
        }catch (IllegalStateException e){
            //当createOrder业务处理过程中产生异常时，对外抛出异常
            //IllegalStateException是JAVA内置状态异常，在项目开发时可以更换为自己项目的自定义异常
            return new ResponseObject(e.getClass().getSimpleName(),e.getMessage());
        }
        return new ResponseObject("0",username+"order created!");
    }

}
