package com.zjq.nacosconfigexample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * <p>自定义配置</p>
 * 配置@RefreshScope实现自动刷新
 * @Author zjq
 * @Date 2021/11/24
 */
@Configuration
@RefreshScope
public class ZjqConfig {

    @Value("${zjq.name}")
    private String name;

    @Value("${zjq.address}")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
