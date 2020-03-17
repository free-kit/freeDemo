package com.freekit.demo.service;

import com.freekit.demo.entity.GoodsInfo;

import java.util.List;

public interface GoodsInfoService {

    void add(GoodsInfo goodsInfo);

    List<GoodsInfo> findAll();
}
