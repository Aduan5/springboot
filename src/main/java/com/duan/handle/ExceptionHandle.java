package com.duan.handle;

import com.duan.controller.GirlController;
import com.duan.domain.Result;
import com.duan.exception.GirlException;
import com.duan.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Aduan
 * 2017/4/13 17:09.
 */
@ControllerAdvice
public class ExceptionHandle {
    private static final Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), e.getMessage());
        } else {
            log.error("系统异常：", e);
            return ResultUtil.error(-1, "未知错误!");
        }
    }
}
