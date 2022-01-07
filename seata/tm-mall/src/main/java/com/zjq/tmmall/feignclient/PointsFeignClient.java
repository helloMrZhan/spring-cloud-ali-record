package com.zjq.tmmall.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * <p>积分接口</p>
 *
 * @Author zjq
 * @Date 2022/1/7
 */
@FeignClient("rm-points")
public interface PointsFeignClient {
    @GetMapping("/add_points")
    public String addPoints(@RequestParam("memberId") Integer memberId, @RequestParam("points") Integer points);
}