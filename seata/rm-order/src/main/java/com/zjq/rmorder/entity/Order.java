package com.zjq.rmorder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>订单JPA实体类</p>
 *
 * @Author zjq
 * @Date 2022/1/5
 */
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @Column(name = "order_id")
    private Integer id; //订单编号
    private Integer memberId; //会员编号

    @Column(name = "goods_id")
    private Integer goodsId; //商品编号
    private Integer points; //新增积分
    private Integer quantity; //销售数量

    public Order() {
    }

    public Order(Integer id, Integer memberId, Integer goodsId, Integer points, Integer quantity) {
        this.id = id;
        this.memberId = memberId;
        this.points = points;
        this.goodsId = goodsId;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
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
