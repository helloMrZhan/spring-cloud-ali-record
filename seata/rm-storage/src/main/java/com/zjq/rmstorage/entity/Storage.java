package com.zjq.rmstorage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * <p>仓储实体</p>
 *
 * @Author zjq
 * @Date 2022/1/7
 */
@Entity
@Table(name = "storage")
public class Storage {
    @Id
    @Column(name = "goods_id")
    private Integer goodsId;
    private Integer quantity;

    public Storage() {
    }

    public Storage(Integer goodsId, Integer quantity) {
        this.goodsId = goodsId;
        this.quantity = quantity;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
