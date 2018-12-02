package com.imooc.demo;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


// 1>.将配置文件中对应前缀的属性映射过来
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {

    private String cupSize;

    private Integer age;

    public GirlProperties(String caoSize, Integer age) {
        this.cupSize = caoSize;
        this.age = age;
    }

    @Override
    public String toString() {
        return "girlProperties{" +
                "cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }

    public GirlProperties() {
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
