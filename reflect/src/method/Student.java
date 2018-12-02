package method;

public class Student {
    //********************成员方法******************//
    public void show1(String s){
        System.out.println("调用了：共有的，String参数的show1（）: s="+s);
    }
    protected void show2(){
        System.out.println("调用了受保护的，无参的show2（）");
    }
    void show3(){
        System.out.println("调用了默认的无参的show3()");
    }
    private String show4(int age){
        System.out.println("调用了，私有的，有返回值的，int参数的show4() age="+age);
        return "abcd";
    }

    private String show5(int age,String name){
        System.out.println("调用了，私有的，有返回值的，int参数的show5() age="+age+"\tname:"+name);
        return "abcd";
    }
}
