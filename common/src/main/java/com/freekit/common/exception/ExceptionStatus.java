package com.freekit.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionStatus {

    CREATE_FILE_DEFEAT(4000, "创建文件失败"),
    FILENAME_IS_EMPTY(4001, "文件是空"),
    PARAMETER_ERROR(4002, "请求参数错误"),
    SERVER_BUSY(5000, "服务器忙,请稍后重试"),
    MAX_FILE_SIZE(425,"文件大小超过5M");

    private int code;
    private String msg;
}
