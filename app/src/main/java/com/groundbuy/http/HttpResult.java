package com.groundbuy.http;

public class HttpResult<T> {
    public static final int SUCCESS_CODE = 200;
    public static final  int FAIL_CODE = 0;
    String msg;
    int code;
    T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
