package com.duan.repository;

import com.duan.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Aduan
 * 2017/4/1 14:49.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    /**
     * 通过年龄查询
     * @param age
     * @return
     */
    List<Girl> findByAge(Integer age);
}
