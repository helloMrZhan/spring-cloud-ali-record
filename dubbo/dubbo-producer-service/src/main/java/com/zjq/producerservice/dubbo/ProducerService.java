package com.zjq.producerservice.dubbo;

import com.zjq.producerservice.entity.User;

/**
 * @author zjq
 * @date 2021/11/20 19:39
 * <p>title:生产者服务</p>
 * <p>description:</p>
 */
public interface ProducerService {

    /**
     * hello world
     * @param username
     * @return
     */
    String hello(String username);

    /**
     * 通过用户名获取用户
     * @param username
     * @return
     */
    User getUserByName(String username);
}
