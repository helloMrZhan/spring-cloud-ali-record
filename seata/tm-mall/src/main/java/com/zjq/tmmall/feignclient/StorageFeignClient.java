package com.zjq.tmmall.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * <p>仓储接口</p>
 *
 * @Author zjq
 * @Date 2022/1/7
 */
@FeignClient("rm-storage")
public interface StorageFeignClient {
    @GetMapping("/reduce_storage")
    public String reduceStorage(@RequestParam("goodsId") Integer goodsId, @RequestParam("quantity") Integer quantity);
}