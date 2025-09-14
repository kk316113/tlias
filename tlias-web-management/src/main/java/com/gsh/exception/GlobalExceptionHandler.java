package com.gsh.exception;

import com.gsh.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("服务器发生异常", e);
        return Result.error("出错啦，请联系管理员~");
    }
    @ExceptionHandler
    public Result mutipleExceptionHandler(DuplicateKeyException e) {
        log.error("服务器发生异常", e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errorMsg =message.substring(i);
        String[]  arr=errorMsg.split(" ");
        return Result.error(arr[2]+"已存在");
    }
}
