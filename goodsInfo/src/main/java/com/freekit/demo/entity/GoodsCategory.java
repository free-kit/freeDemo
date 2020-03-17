package com.freekit.demo.entity;

import com.freekit.demo.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "goods_category")
@Data
public class GoodsCategory extends BaseEntity {

    @Column(name  = "category_name")
    private String categoryName;
}
