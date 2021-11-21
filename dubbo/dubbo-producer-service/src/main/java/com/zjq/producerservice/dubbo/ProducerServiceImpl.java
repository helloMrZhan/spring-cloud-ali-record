package com.zjq.producerservice.dubbo;

import com.zjq.producerservice.entity.User;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author zjq
 * @date 2021/11/20 19:42
 * <p>title:生产者服务</p>
 * <p>@DubboService 是 Provider 注解，说明该类所有方法都是服务提供者，加入该注解会自动将类与方法的信息
 * 在 Nacos中注册为 Provider。</p>
 */
@DubboService
public class ProducerServiceImpl implements ProducerService{

    @Override
    public String hello(String username) {
        return "hello "+username+", I'm producer service,follow me,go go go.";
    }

    @Override
    public User getUserByName(String username) {
        if("zjq".equals(username)){
            return new User("zjq","123456","HS");
        }else {
            return new User("二狗子","123456","HS");
        }
    }
}
