package com.duan.enums;

/**
 * Created by Aduan
 * 2017/4/13 17:21.
 */
public enum GirlEnum {
    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能还在上初中");

    private Integer code;
    private String msg;

    GirlEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
