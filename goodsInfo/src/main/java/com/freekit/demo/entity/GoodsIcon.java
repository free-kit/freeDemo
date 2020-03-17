package com.freekit.demo.entity;

import com.freekit.demo.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "goods_icon")
@Data
public class GoodsIcon extends BaseEntity {

    @Column(name  = "goods_icon")
    private String goodsIcon;

    @Column(name  = "goods_id")
    private Long goodsId;


}
