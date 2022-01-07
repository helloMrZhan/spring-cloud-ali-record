package com.zjq.rmstorage.service;

import com.zjq.rmstorage.entity.Storage;
import com.zjq.rmstorage.repository.StorageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
/**
 * <p>仓储service</p>
 *
 * @Author zjq
 * @Date 2022/1/7
 */
@Service
public class StorageService {
    @Resource
    private StorageRepository storageRepository;

    @Transactional
    public Storage reduceStorage(Integer goodsId, Integer quantity){
        Storage storage = storageRepository.findById(goodsId).get();
        if(storage.getQuantity() < quantity){
            throw new IllegalStateException(goodsId + "商品库存不足");
        }
        storage.setQuantity(storage.getQuantity() - quantity);
        return storageRepository.save(storage);
    }
}
