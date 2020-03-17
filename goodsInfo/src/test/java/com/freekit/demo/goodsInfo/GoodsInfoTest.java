package com.freekit.demo.goodsInfo;

import com.alibaba.fastjson.JSON;
import com.freekit.demo.DemoApplicationTests;
import com.freekit.demo.entity.GoodsInfo;
import com.freekit.demo.enums.GoodsStatusEnum;
import com.freekit.demo.service.GoodsInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
public class GoodsInfoTest extends DemoApplicationTests {

    @Autowired
    private GoodsInfoService goodsInfoService;

    @Test
    public void insertGoodsInfo(){
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setGoodsName("哇哈哈");
        goodsInfo.setGoodsDescripe("喝的");
        goodsInfo.setGoodsOrigin("草地");
        goodsInfo.setGoodsStock(100l);
        goodsInfo.setGoodsStatus(GoodsStatusEnum.UP.getCode());
        goodsInfo.setGoodsPrice(new BigDecimal(12));
        System.out.println(goodsInfo.getId());
        List<GoodsInfo> all = goodsInfoService.findAll();
        log.info("返回信息{}", JSON.toJSONString(all));

    }
}
