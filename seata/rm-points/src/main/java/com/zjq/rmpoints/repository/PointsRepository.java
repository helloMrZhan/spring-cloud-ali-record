package com.zjq.rmpoints.repository;

import com.zjq.rmpoints.entity.Points;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 积分dao
 * @author zjq
 */
public interface PointsRepository extends JpaRepository<Points,Integer> {

}
