package com.freekit.common.entity;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {

    /**
     * 状态码, 200 表示成功
     */
    private int code;
    /**
     *提示信息
     */
    private String msg;
    /**
     *总数量
     */
    private long count;
    /**
     *当前数据
     */
    private List<T> data;

    public Page() {
    }

    public Page(List<T> rows) {
        this.data = rows;
        this.count = rows.size();
        this.code = 200;
        this.msg = "";
    }

    public Page(List<T> rows, long total) {
        this.count = total;
        this.data = rows;
        this.code = 200;
        this.msg = "";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
