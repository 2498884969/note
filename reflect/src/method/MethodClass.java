package method;

import java.lang.reflect.Method;

/**
 * 获取成员方法并调用：
 *
 * 1.批量的：
 * 		public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
 * 		public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
 * 2.获取单个的：
 * 		public Method getMethod(String name,Class<?>... parameterTypes):
 * 					参数：
 * 						name : 方法名；
 *      Class ... : 形参的Class类型对象
 * 		public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 *
 * 	 调用方法：
 * 		Method --> public Object invoke(Object obj,Object... args):
 * 					参数说明：
 * 					obj : 要调用方法的对象；
 * 					args:调用方式时所传递的实参；
 *   ):
 */

public class MethodClass {
    public static void main(String[] args) throws Exception {
        //1.获取Class对象
        Class stuClass = Class.forName("method.Student");
        //2.获取所有公有构造方法
        System.out.println("*******************获取所有公有构造方法*******************");
        Method[] methodArray = stuClass.getMethods();
        for(Method m:methodArray){
            System.out.println(m);
        }
        //3>.获取所有的方法，包括私有的
        System.out.println("*******************获取所有的方法，包括私有的********************");
        methodArray = stuClass.getDeclaredMethods();
        for (Method m:methodArray){
            System.out.println(m);
        }
        //4>.获取公有的show1()方法
        System.out.println("**********获取公有的show1()方法***********");
        Method m = stuClass.getMethod("show1", String.class);
        System.out.println(m);
        //5>.实例化一个Student对象
        Object obj = stuClass.getConstructor().newInstance();
        m.invoke(obj,"刘德华");
        //6>.获取私有的show4()方法
        System.out.println("*************获取私有的show4()方法***********");
        m = stuClass.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true);//解除私有限定
        Object res = m.invoke(obj,20);
        System.out.println("返回值：" + res);
        //7>.有两个参数的show5方法
        System.out.println("***************有两个参数的show5方法****************");
        m = stuClass.getDeclaredMethod("show5", int.class, String.class);
        m.setAccessible(true);
        res = m.invoke(obj,20,"Danny");
        System.out.println(res);

    }
}
