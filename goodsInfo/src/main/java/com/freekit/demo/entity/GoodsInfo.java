package com.freekit.demo.entity;

import com.freekit.demo.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "goods_info")
@Data
public class GoodsInfo extends BaseEntity {

    @Column(name  = "goods_name")
    private String goodsName;

    @Column(name  = "goods_descripe")
    private String goodsDescripe;

    @Column(name  = "goods_picture")
    private String goodsPicture;

    @Column(name  = "goods_origin")
    private String goodsOrigin;

    @Column(name  = "goods_stock")
    private Long goodsStock;

    @Column(name  = "goods_price")
    private BigDecimal goodsPrice;

    @Column(name  = "goods_status",insertable = false)
    private int goodsStatus;

}
