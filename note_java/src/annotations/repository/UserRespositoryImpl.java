package annotations.repository;

import annotations.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//("userRespository")
//如果接口有两个派生类，可以让bean的名字和set方法的传参名(字段名)一致
@Repository
public class UserRespositoryImpl implements UserRespository {

    @Autowired(required = false)
    private TestObject testObject;

    @Override
    public void save() {

        System.out.println("UserRepository Save...");
        System.out.println(testObject);
    }
}
