package com.imooc.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * ALTER TABLE girl ENGINE=innodb，使用命令修改表引擎，只有在innodb引擎下事务才能工作。
 */



@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class GirlService {

    @Autowired
    private GirlRespository girlRespository;

    public void InsertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRespository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBBBB");
        girlB.setAge(19);
        girlRespository.save(girlB);
    }

}
