package example.config;

import example.Condition.LinuxCondition;
import example.Condition.MyImportBeanDefinitionRegistrar;
import example.Condition.MyImportSelector;
import example.Condition.WindowsCondition;
import example.bean.Color;
import example.bean.ColorFactoryBean;
import example.bean.Person;
import example.bean.Red;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

// 满足注册条件，类中的所有bean注册才能生效

/**
 * @Conditional满足条件才导入
 */

@Conditional({WindowsCondition.class})
@Configuration
@Import(value = {Color.class, Red.class, MyImportSelector.class,
        MyImportBeanDefinitionRegistrar.class})
//  导入组件id默认为组件的全类名
public class MainConfig2 {

//    	 * @see
//    ConfigurableBeanFactory#SCOPE_PROTOTYPE   prototype
//	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON     singleton
//	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST     request
//	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION     session
//	 * @see #value

    /**
     * prototype    多实例的
     * singleton    单实例的
     * request      同一个请求创建一个实例
     * @return      同一个session创建一个实例
     *
     * 单实例的（默认值），在IOC容器启动的时候会将bean对象存入容器之中
     * 多实例情况下，IOC容器在每次获取兑现的时候创建对象
     *
     * 懒加载：针对于单实例对象而言
     *          容器启动的时候不创建对象，第一次使用的时候创建的对象
     */
    @Scope
    @Bean(name = "person")
    public Person person(){
        System.out.println("给容器中添加person...");
        return new Person("张三",25);
    }

    /**
     * @Conditional
     * 如果系统是windows，就注册("bill")到IOC容器中
     * 如果系统是linux，就注册("linus")到IOC容器中
     * @return
     */

    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("bill gates",62);
    }


    @Conditional(value = {LinuxCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("linus",62);
    }
    /**
     * 按照一定的条件进行判断，满足条件给容器中注册bean
     *
     * 给容器中注册组件：
     * 1>.包扫描+组件标注注解(@Controller/@Service/@Repository/@Component)（自己写的类）
     * 2>.@Bean导入的第三方包里面的组件
     * 3>.@Import快速给容器中导入一个组件
     *      1>.直接@import(要导入到容器中的组件)，容器中就会自动注册这个组件，id默认是全类名
     *      2>.ImportSelector:返回需要导入的组件的全类名的数组（用的较多通过判断进行）
     *      3>.ImportBeanDefinitionRegistrar:
     *      4>.使用FactoryBean（工厂bean）
     *          1>.默认获取的是工厂bean的getObject方法生成的bean。
     *          2>.获取工厂bean本身需要在id前加上默认前缀"&"
     *          &colorFactoryBean
     */

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
