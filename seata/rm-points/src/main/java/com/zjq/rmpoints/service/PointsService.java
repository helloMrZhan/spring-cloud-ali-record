package com.zjq.rmpoints.service;

import com.zjq.rmpoints.entity.Points;
import com.zjq.rmpoints.repository.PointsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 积分service
 * @author zjq
 */
@Service
public class PointsService {
    @Resource
    private PointsRepository orderRepository;

    @Transactional
    public Points addPoints(Integer memberId, Integer points){
        Points entity = orderRepository.findById(memberId).get();
        entity.setPoints( entity.getPoints() + points);
        return orderRepository.save(new Points(memberId,entity.getPoints()));
    }
}
