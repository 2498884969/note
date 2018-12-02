package example.config;

import example.bean.Person;
import example.dao.BookDao;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//配置类==配置文件
@Configuration      //告诉spring这是一个配置类
//@ComponentScan(value = "example",excludeFilters = {
//        @Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Controller.class})
//})

//@ComponentScan(basePackages={"example"},
//        excludeFilters={@Filter(type=FilterType.ANNOTATION,value={Controller.class,Service.class})})
//@ComponentScan(basePackages={"example"},
//        includeFilters={@Filter(type=FilterType.ANNOTATION,value={Controller.class,Service.class})},
//        useDefaultFilters = false)
@ComponentScans(value = {
    @ComponentScan(basePackages={"example"},
            includeFilters={
//            @Filter(type=FilterType.ANNOTATION,value={Controller.class}),
//            @Filter(type = FilterType.ASSIGNABLE_TYPE,value = {BookDao.class}),
            @Filter(type = FilterType.CUSTOM,value = {MyTypeFilter.class})
            },
            useDefaultFilters = false)
})
//ComponentScan    value:指定要扫描的包
//excludeFilters = Filters[] 指定要排除的组件
//excludeFilters = Filters[] 指定要包含的组件
//ASSIGNABLE_TYPE,按照给定的类型进行过滤
//ASPECTJ
//REGEX按照正则表达式过滤
//CUSTOM 自定义过滤规则
public class MainConfig {

    //给容器中注册一个bean;类型为返回值的类型，id默认为方法名作为id
    @Bean(name = "person")
    public Person person(){
        return new Person("lisi",20);
    }

}
