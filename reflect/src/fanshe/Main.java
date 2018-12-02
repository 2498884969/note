package fanshe;

/**
 * 获取Class对象的三种方式：
 * 1.Object-->getClass()
 * 2.任何数据类型（包括静态数据类型）都有一个“静态”的class属性
 * 3.通过Class类的静态方法：forname(String className)(常用)
 */

public class Main {
    public static void main(String[] args) {
        //方法1
        Student stu1 = new Student();
        Class stuClass = stu1.getClass();
        System.out.println(stuClass.getName());

        //方法2
        Class stuClass2 =Student.class;
        System.out.println(stuClass==stuClass2);

        // 方法3
        try{
            Class stuClass3 = Class.forName("fanshe.Student");
            System.out.println(stuClass3==stuClass2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
