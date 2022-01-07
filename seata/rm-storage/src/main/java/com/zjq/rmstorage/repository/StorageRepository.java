package com.zjq.rmstorage.repository;

import com.zjq.rmstorage.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * <p>仓储dao</p>
 *
 * @Author zjq
 * @Date 2022/1/7
 */
public interface StorageRepository extends JpaRepository<Storage,Integer> {

}
