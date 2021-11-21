package com.zjq.consumerservice.controller;

import com.zjq.producerservice.dubbo.ProducerService;
import com.zjq.producerservice.entity.User;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>测试dubbo</p>
 *
 * @Author zjq
 * @Date 2021/11/17
 */
@RestController
@RequestMapping(value = "dubbo")
public class DubboTestController {

    private Logger log = LoggerFactory.getLogger(DubboTestController.class);

    /**
     * @DubboReference 注解用在 Consumer 端，说明 ProducerService 是 Dubbo Consumer 接口，Spring 会自动生成
     * ProducerService 接口的代理实现类，并隐藏远程通信细节
     */
    @DubboReference
    /**
     * ProducerService接口包路径全路径必须跟生产者提供的接口路径一致不然会报找不到对应的服务
     */
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
