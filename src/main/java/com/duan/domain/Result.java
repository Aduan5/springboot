package com.duan.domain;

/**
 * Created by Aduan
 * 2017/4/13 16:44.
 */
public class Result<T> {
    /** 错误代码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体类容 */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
