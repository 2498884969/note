package annotations.service;

import annotations.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Qualifier("UserRespositoryImpl")

@Service
public class UserService {

//    @Autowired
    private UserRespository userRespository;

    @Autowired
    public void setUserRespository(@Qualifier("userRespositoryImpl") UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    public void add(){
        System.out.println("UserService Add.......");
        userRespository.save();
    }
}
