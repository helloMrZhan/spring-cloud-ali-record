package com.zjq.consumerservice.feignclient;

import com.zjq.consumerservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>测试OpenFeign</p>
 *
 *  @FeignClient 注解说明当前接口为 OpenFeign 通信客户端，参数值 producer-service 为服务提供者 ID，这一项必须与 Nacos 注册 ID
 * 保持一致。在 OpenFeign 发送请求前会自动在 Nacos 查询 producer-service 所有可用实例信息，再通过内置的 Ribbon 负载均衡选择一个
 * 实例发起 Restful 请求，进而保证通信高可用。
 * @Author zjq
 * @Date 2021/11/17
 */
@FeignClient(serviceId = "producer-service")
public interface ProducerServiceClient {

    @GetMapping(value = "/feign/hello")
    String hello(@RequestParam("username") String username);

    @GetMapping(value = "/feign/getUser")
    User getUserByName(@RequestParam("username") String username);

}
