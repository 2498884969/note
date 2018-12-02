package example.Condition;

import example.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    //>.AnnotationMetadata      当前import注解的所有注解信息

    /**
     * BeanDefinitionRegistry：BeanDefinition注册类
     *  把所有需要添加到容器中的bean
     *  BeanDefinitionRegistry：registerBeanDefinition手工注册
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean defination = registry.containsBeanDefinition("example.bean.Red");
        boolean defination1 = registry.containsBeanDefinition("example.bean.Blue");
        //>.指定bean的定义信息
        RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
        if(defination && defination1){
        //>.将bean注册到容器中
            registry.registerBeanDefinition("rainBow",beanDefinition);
        }
    }
}
