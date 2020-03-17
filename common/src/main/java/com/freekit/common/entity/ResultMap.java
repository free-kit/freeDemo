package com.freekit.common.entity;

import com.freekit.common.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResultMap extends HashMap<String,Object> {
    public static final int success = 200;
    private int code;
    private String msg;
    private Object data;

    public ResultMap(int code,Object data){
        this.code = code;
        this.data = data;
    }

    public ResultMap(int code){
        this.code = code;
    }

   public static  ResultMap ok(){
        return new ResultMap(success);
    }

    public static  ResultMap ok(Object data){
        return new ResultMap(success,data);
    }

    public static  ResultMap ok(int code,Object data){
        return new ResultMap(code,data);
    }

    public static ResultMap ok(BusinessException e) {
        return new ResultMap(e.getCode(), e.getMessage(), null);
    }
}
