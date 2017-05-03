package com.duan.service;

import com.duan.domain.Girl;
import com.duan.enums.GirlEnum;
import com.duan.exception.GirlException;
import com.duan.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Aduan
 * 2017/4/11 10:34.
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCoupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCoupSize("BBB");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            // 你还在上小学吧
            throw new GirlException(GirlEnum.PRIMARY_SCHOOL);
        } else if (age < 16){
            // 你还在上中学吧
            throw new GirlException(GirlEnum.MIDDLE_SCHOOL);
        }
    }

    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}

