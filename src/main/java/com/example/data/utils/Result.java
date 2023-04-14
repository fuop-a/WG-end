package com.example.data.utils;

import lombok.Data;

@Data
public class Result<T> {


    private Integer code;

    private String msg;

    private T data;

    /**
     * 成功不返回数据
     * @return
     */
    public Result success(){
        Result result=new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMsg("请求成功");
        return result;
    }

    public Result success(Object data){
        Result result=new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMsg("请求成功");
        result.setData(data);
        return result;
    }

    public Result error(int code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
