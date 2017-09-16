package com.hello.common;

/**
 * 统一响应
 */
public class ResultResponse {
    boolean success=false;
    String msg;
    Object data;
    public ResultResponse(){}
    public ResultResponse success(String msg){
        this.success=true;
        this.msg=msg;
        return this;
    }
    public ResultResponse fail(String msg){
        this.success=false;
        this.msg=msg;
        return this;
    }
    public ResultResponse data(Object data){
        this.data=data;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}
