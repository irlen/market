package com.irlen.market.result;

public class ResultUtil {
    public static Result success(Object data){
        Result result = new Result();
        result.setCode(1);
        result.setMsg("成功");
        result.setData(data);
        return result;
    }
    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setMsg(msg);
        result.setCode(code);
        result.setData(null);
        return result;
    }
}
