package example.Condition;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        /**
         * ConditionContext context         能使用的上下文环境
         *
         * AnnotatedTypeMetadata metadata   注释信息
         */
        //1>.能获取到IOC使用的beanfactory
        ConfigurableBeanFactory beanFactory = context.getBeanFactory();
        //2>.获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3>.获取当前环境信息
        Environment environment = context.getEnvironment();
        //4>.获取到bean的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        //可以判断容器中的bean注册情况也可以给容器中注册bean
//        if(registry.containsBeanDefinition("person")){
//            return true;
//        }

        String property = environment.getProperty("os.name");
        if (property.contains("linux")){
            return true;
        }
        return false;
    }
}
