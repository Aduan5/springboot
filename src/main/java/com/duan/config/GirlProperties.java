package com.duan.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Aduan
 * 2017/4/1 13:52.
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {

    private String name;
    private String coupSize;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoupSize() {
        return coupSize;
    }

    public void setCoupSize(String coupSize) {
        this.coupSize = coupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "GirlProperties{" +
                "name='" + name + '\'' +
                ", coupSize='" + coupSize + '\'' +
                ", age=" + age +
                '}';
    }
}