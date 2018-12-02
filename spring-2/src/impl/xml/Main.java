package impl.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 1>.创建spring的IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
        // 2>.从IOC容器中获取bean实例
        AtithmeticCaculator atithmeticCaculator = ctx.getBean(AtithmeticCaculator.class);
        // 3>.获取备案实例
        int result = atithmeticCaculator.add(3,6);
        System.out.println("result=>" + result);

        result = atithmeticCaculator.div(12,0);
        System.out.println("result=>" + result);
    }
}
