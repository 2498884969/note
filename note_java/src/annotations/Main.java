package annotations;

import annotations.Controller.UserController;
import annotations.repository.UserRespository;
import annotations.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotations.xml");

//        TestObject to = (TestObject) ctx.getBean("testObject");
//        System.out.println(to);
//
        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println(userController);
        userController.execute();


//        UserRespository userRespository = (UserRespository) ctx.getBean("userRespository");
//        System.out.println(userRespository);

//        UserService userService = (UserService) ctx.getBean("userService");
//        System.out.println(userService);
    }
}
