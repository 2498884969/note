package fanxing;

import java.util.ArrayList;

/**
 * 通过反射越过泛型检查
 *
 * 例如：有一个String泛型的集合，怎样向这个集合中添加一个Integer类型的值
 *
 *
 */


public class Method {
    public static void main(String[] args) throws Exception{
        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");

        //>.获取ArrayList的Class对象，反向调用add()方法，添加数据
        //1>.得到ArrayList的Class对象
        Class listClass = strList.getClass();
        //2>.获取add()方法
        java.lang.reflect.Method m = listClass.getMethod("add", Object.class);
        //3>.调用add()方法
        m.invoke(strList,100);

        //>.遍历集合
        for(Object obj:strList){
            System.out.println(obj);
        }
    }




}
