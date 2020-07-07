package com.example.qi.myandroidstructure.network.base;

/*
* 所有数据的基类
* */
public class HttpResult<T> {
    private int code; // 服务器返回状态码
    private String message;
    private T data; // 真实数据类

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
