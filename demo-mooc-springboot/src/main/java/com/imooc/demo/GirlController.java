package com.imooc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRespository girlRespository;

    @Autowired
    private GirlService girlService;

    @GetMapping("/girls")
    public List<Girl> girlList(){
        return girlRespository.findAll();
    }

    @PostMapping("/addGirl")
    public String addGirl(@RequestBody Girl girl){
        return girlRespository.save(girl).toString();
    }

    @PostMapping(value = "/updateGirl")
    public Girl girlUpdate(@RequestBody Girl girl){
        return girlRespository.save(girl);
    }

    @GetMapping("/girl/{id}")
    public Girl getOneFurl(@PathVariable("id") Integer id){

        Girl girl = girlRespository.getOne(id);

        return girl;
    }

    @DeleteMapping(value = "deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        girlRespository.deleteById(id);
    }

    @GetMapping(value = "findGirlsByAge/{age}")
    public List<Girl> findGirlsByAge(@PathVariable("age") Integer age){
        return girlRespository.findGirlsByAge(age);
    }

    @PostMapping(value = "/insrtTwo")
    public void insrtTwo(){
        girlService.InsertTwo();
    }

}
