package com.duan.controller;

import com.duan.config.GirlProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Aduan
 * 2017/4/1 13:32.
 */
@Controller
public class HelloController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private GirlProperties girlProperties;

    @GetMapping(value = "/say")
    @ResponseBody
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "id : " + id + " , girl : " + girlProperties.toString();
    }

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/login")
    public String login() {
        return "login";
    }
}
