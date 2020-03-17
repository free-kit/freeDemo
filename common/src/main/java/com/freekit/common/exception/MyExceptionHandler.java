package com.freekit.common.exception;

import com.freekit.common.entity.ResultMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.List;

@RestControllerAdvice
public class MyExceptionHandler {
    /**
     * 处理请求对象属性不满足校验规则的异常信息
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    private ResultMap exception(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder builder = new StringBuilder();
        for (FieldError error : fieldErrors) {
            builder.append(error.getDefaultMessage());
        }
        return new ResultMap(ExceptionStatus.PARAMETER_ERROR.getCode(), builder.toString());
    }

    /**
     * 处理请求单个参数不满足校验规则的异常信息
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResultMap constraintViolationExceptionHandler(ConstraintViolationException exception) {
        return new ResultMap(ExceptionStatus.PARAMETER_ERROR.getCode(), exception.getMessage());
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResultMap ErrorMaxUploadSizeExceededExceptionHandler(MaxUploadSizeExceededException e) {
        return ResultMap.ok(ExceptionStatus.MAX_FILE_SIZE);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResultMap IOExceptionHandler(IOException e) {
        return ResultMap.ok(1,e);
    }
}
