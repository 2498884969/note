package example.test;

import example.bean.Blue;
import example.bean.Person;
import example.config.MainConfig;
import example.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.Map;

public class IOCTest {


    @SuppressWarnings(value ="resources")
    @Test
    public void test01(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        String []DefinationNames = ctx.getBeanDefinitionNames();
        for(String name:DefinationNames){
            System.out.println(name);
        }
    }

    @SuppressWarnings(value ="resources")
    @Test
    public void test02(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig2.class);
        String []DefinationNames = ctx.getBeanDefinitionNames();
        for(String name:DefinationNames){
            System.out.println(name);
        }

        System.out.println("IOC容器创建完成");
        Object bean = ctx.getBean("person");
        Object bean2 = ctx.getBean("person");
        System.out.println(bean == bean2);
    }

    @Test
    public void test03(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig2.class);
        String []namesType = ctx.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = (ConfigurableEnvironment) ctx.getEnvironment();
        String osName = environment.getProperty("os.name");
//      动态获取环境变量的值：Windows 10
//        System.out.println(osName);


        for(String name:namesType){
            System.out.println(name);
        }

        Map map = ctx.getBeansOfType(Person.class);
        System.out.println(map);
    }

    @Test
    public void testImport(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig2.class);
        printBeans(ctx);
        Blue blue = ctx.getBean(Blue.class);
        System.out.println(blue);
        //>.工厂bean获取的是调用个体Object方法创建的对象

        Object bean2 = ctx.getBean("colorFactoryBean");
        Object bean3 = ctx.getBean("colorFactoryBean");
        Object bean4 = ctx.getBean("&colorFactoryBean");
        System.out.println(bean2==bean3);
        System.out.println("bean的类型为"+ctx.getBean("colorFactoryBean").getClass());
        System.out.println("bean4的类型为："+bean4.getClass());


    }

    private void printBeans(AnnotationConfigApplicationContext ctx){
        String []names = ctx.getBeanDefinitionNames();
        for (String name:names){
            System.out.println(name);
        }
    }
}
