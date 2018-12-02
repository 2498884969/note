package fanshe;

import java.lang.reflect.Field;

public class Fields {

    public static void main(String[] args) throws Exception {
        //1.获取Class对象
        Class stuClass = Class.forName("fanshe.Student");
        //2.获取获取所有公有的字段
        System.out.println("************获取所有公有的字段********************");
        Field[] fieldArray = stuClass.getFields();
        for(Field f:fieldArray){
            System.out.println(f);
        }
        //3.获取所有的字段(包括私有、受保护、默认的)
        System.out.println("************获取所有的字段(包括私有、受保护、默认的)*******************");

        fieldArray = stuClass.getDeclaredFields();
        for(Field f:fieldArray){
            System.out.println(f);
        }

        //4.获取公有字段**并调用
        System.out.println("*************获取公有字段**并调用***************************");
        Field f = stuClass.getField("name");
        System.out.println(f);
        //获取一个对象
        Object obj = stuClass.getConstructor().newInstance();//产生student对象
        //为字段设置值
        f.set(obj,"刘德华");
        //验证
        Student stu = (Student)obj;
        System.out.println("验证姓名："+stu.name);

        //5.获取私有字段****并调用
        System.out.println("**************获取私有字段****并调用************************");
        f =stuClass.getDeclaredField("phoneNum");
        System.out.println(f);
        f.setAccessible(true);//暴力反射，解除私有限定
        f.set(obj,"1383838438");
        System.out.println(stu);
    }


}
