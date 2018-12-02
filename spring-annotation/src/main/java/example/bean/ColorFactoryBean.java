package example.bean;

import org.springframework.beans.factory.FactoryBean;

//>.创建一个spring创建的工厂bean
public class ColorFactoryBean implements FactoryBean<Color> {

    //>.1.返回一个color对象这个对象会添加到容器中
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    //>.2.控制是否为单例
    //>.true:单实例    false：多实例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
