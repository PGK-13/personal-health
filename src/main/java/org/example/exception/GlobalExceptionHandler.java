package org.example.exception;

import org.example.pojo.dto.Code;
import org.example.pojo.result.Result;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingRequestHeaderException.class)
    public Result handleMissingHeader(MissingRequestHeaderException e) {
        return new Result(Code.SYSTEM_ERR, e.getHeaderName());
    }

    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e) {
        e.printStackTrace();
        return new Result(Code.SYSTEM_ERR, e.getMessage());
    }

}
