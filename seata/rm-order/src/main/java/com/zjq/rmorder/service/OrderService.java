package com.zjq.rmorder.service;

import com.zjq.rmorder.entity.Order;
import com.zjq.rmorder.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
/**
 * <p>订单service</p>
 *
 * @Author zjq
 * @Date 2022/1/5
 */
@Service
public class OrderService {
    @Resource
    private OrderRepository orderRepository;

    @Transactional
    public Order createOrder(Integer orderId,Integer memberId,Integer goodsId,Integer points,Integer quantity){
        return orderRepository.save(new Order(orderId, memberId,goodsId,points,quantity));
    }
}
