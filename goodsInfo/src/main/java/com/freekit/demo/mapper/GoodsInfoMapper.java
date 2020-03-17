package com.freekit.demo.mapper;

import com.freekit.demo.entity.GoodsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsInfoMapper extends JpaRepository<GoodsInfo,Long> {
}
