package file;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws Exception {
        //1>.通过反射获取class对象
        System.out.println(getValue("className"));
        Class stuClass = Class.forName(getValue("className"));
        //2>.获取show()方法
        Method m = stuClass.getMethod(getValue("methodName"));
        //3>.调用show()方法
        m.invoke(stuClass.getConstructor().newInstance());
    }


    public static String getValue(String key) throws IOException{
        //1>.生成获取配置属性的对象
        Properties pro = new Properties();
        //2>.获取输入流
        FileReader in  = new FileReader("F:\\笔记仓库\\reflect\\src\\pro.txt");
        pro.load(in);
        in.close();
        return pro.getProperty(key);
    }
}
