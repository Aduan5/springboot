package com.duan.domain;

import org.springframework.beans.factory.annotation.Required;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

/**
 * Created by Aduan
 * 2017/4/1 14:33.
 */
@Entity
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;

    private String coupSize;
    @Min(value = 18,message = "禁止未成年少女入内")
    private Integer age;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "Girl{" +
                "id=" + id +
                ", coupSize='" + coupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
