package collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");

        Person person = (Person) ctx.getBean("person6");
        System.out.println(person);
//        NewPerson person = (NewPerson) ctx.getBean("person4");
//        System.out.println(person);
//        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
//        System.out.println(dataSource);
    }
}
