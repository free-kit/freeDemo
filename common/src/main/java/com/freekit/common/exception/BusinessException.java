package com.freekit.common.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private int code;

    public BusinessException() {
        super(ExceptionStatus.SERVER_BUSY.getMsg());
        this.code = ExceptionStatus.SERVER_BUSY.getCode();
    }

    public BusinessException(ExceptionStatus status) {
        super(status.getMsg());
        this.code = status.getCode();
    }

    public BusinessException(ExceptionStatus status, String msg) {
        super(msg);
        this.code = status.getCode();
    }

    public BusinessException(ExceptionStatus status, Throwable e) {
        super(status.getMsg(), e);
        this.code = status.getCode();
    }

}
