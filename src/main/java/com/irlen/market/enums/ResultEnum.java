package com.irlen.market.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(1, "成功");

    private Integer code;
    private String msg;
    //枚举类的构造函数不能有public修饰符，注意枚举类不能派生子类（类的默认修饰符为final)
     ResultEnum(Integer code, String msg){
        this.code =  code;
        this.msg = msg;
    }
}
