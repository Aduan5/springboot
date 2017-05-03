package com.duan.exception;

import com.duan.enums.GirlEnum;

/**
 * Created by Aduan
 * 2017/4/13 17:06.
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(GirlEnum girlEnum) {
        super(girlEnum.getMsg());
        this.code = girlEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
