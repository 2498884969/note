package com.imooc.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRespository extends JpaRepository<Girl,Integer> {

    public List<Girl> findGirlsByAge(Integer age);

}
