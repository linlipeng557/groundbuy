package com.groundbuy.http;

import java.io.Serializable;

public class HttpResult<T>  implements Serializable {
    public static final int SUCCESS_CODE = 0;
    public static final  int FAIL_CODE = 1;
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
