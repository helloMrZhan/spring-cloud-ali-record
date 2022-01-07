package com.zjq.tmmall.controller;

import com.zjq.tmmall.service.MallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * <p>商城控制层</p>
 *
 * @Author zjq
 * @Date 2022/1/7
 */
@RestController
public class MallController {
    @Resource
    private MallService mallService;

    @GetMapping("/sale")
    public String sale(Integer orderId,Integer memberId,Integer goodsId,Integer points,Integer quantity){
        return mallService.sale(orderId,memberId,goodsId,points,quantity);
    }
}
