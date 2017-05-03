package com.duan.aspect;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Aduan
 * 2017/4/11 11:20.
 */
@Aspect
@Component
public class HttpAspect {
    private static final Logger log = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.duan.controller.GirlController.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        log.info("doBefore ***************** ");
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // rul
        log.info("url = {}",request.getRequestURL());

        // method
        log.info("method = {}",request.getMethod());

        // ip
        log.info("ip = {}",request.getRemoteAddr());

        // 类方法
        log.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        // 参数
        log.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        log.info("doAfter ****************");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void afterReturning(Object  object){
        log.info("response={}",object);
    }
}
