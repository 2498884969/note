package example;

import example.bean.Person;
import example.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) ctx.getBean("person");
//        System.out.println(person);

        ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = ctx.getBean(Person.class);
        System.out.println(person);

        String []namesForType = ctx.getBeanNamesForType(Person.class);
        for(String name:namesForType){
            System.out.println(name);
        }


    }
}
