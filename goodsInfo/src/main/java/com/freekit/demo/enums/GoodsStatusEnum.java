package com.freekit.demo.enums;

import lombok.Getter;

@Getter
public enum GoodsStatusEnum {
    UP(0,"上架"),
    DOWN(1,"下架");
    private int code;
    private String msg;
    GoodsStatusEnum(int i, String 上架) { }
}
