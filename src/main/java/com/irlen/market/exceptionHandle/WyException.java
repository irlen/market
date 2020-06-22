package com.irlen.market.exceptionHandle;

import com.irlen.market.enums.ResultEnum;
import lombok.Data;

@Data
public class WyException extends RuntimeException{
    private Integer code;
    public WyException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
