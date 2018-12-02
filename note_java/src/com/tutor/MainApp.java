package com.tutor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        /**
         * 1.获取Beans.xml文件上下文
         * 2.通过上下文导入对象
         * 3.调用对象的方法
         */
        // context为IOC容器，只有IOC容器实例化之后，我们才可以从IOC容器中获取对象
        /**
         * spring提供两种IOC容器BeanFactory和ApplicationContext,其中BeanFactory是面向spring底层的
         * 而ApplicationContext是面向开发者的，无论使用何种方式配置方式是一样的
         * ClassPathXmlApplicationContext：是ApplicationContext的一个实现类。该实现类从类路径下加载配置文件
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//        通过id来获取对象
//        Helloworld obj1 = (Helloworld) context.getBean("helloWorld");
        //通过类名来获取对象，但要求容器中只含有一个该类型的bean
//        Helloworld obj1 = context.getBean(Helloworld.class);
//        obj1.getMessage();
//          Car car = (Car) context.getBean("car");
//          System.out.println(car);
//
//          Car car2 = (Car) context.getBean("car2");
//          System.out.println(car2);

            Person person = (Person) context.getBean("person2");
            System.out.println(person);
    }



}
