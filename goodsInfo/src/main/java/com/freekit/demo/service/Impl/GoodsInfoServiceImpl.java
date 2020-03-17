package com.freekit.demo.service.Impl;

import com.alibaba.fastjson.JSON;
import com.freekit.demo.entity.GoodsInfo;
import com.freekit.demo.mapper.GoodsInfoMapper;
import com.freekit.demo.service.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {

    @Autowired
    private GoodsInfoMapper  goodsInfoMapper;

    @Override
    public void add(GoodsInfo goodsInfo) {
        GoodsInfo save = goodsInfoMapper.save(goodsInfo);
        if(null != save){
            System.out.println(JSON.toJSONString(save));
        }
    }

    @Override
    public List<GoodsInfo> findAll() {
        return goodsInfoMapper.findAll();
    }
}
