package com.zjq.rmorder.repository;

import com.zjq.rmorder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * <p>订单dao</p>
 *
 * @Author zjq
 * @Date 2022/1/5
 */
public interface OrderRepository extends JpaRepository<Order,Integer> {

}
