package com.wkl.girl;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理
 */
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public  Result handle(Exception exception) {
        if (exception instanceof GirlException) {
            GirlException e = (GirlException) exception;
            return new Result(e.getResultEnum().getCode(), e.getResultEnum().getMsg(), null);
        }
        return new Result("-1",exception.getMessage(), null);
    }
}
