package com.irlen.market.exceptionHandle;

import com.irlen.market.result.Result;
import com.irlen.market.result.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof WyException){
            WyException wyException = (WyException) e;
            return ResultUtil.error(wyException.getCode(),wyException.getMessage());
        }
        return ResultUtil.error(0,e.getMessage());
    }
}
