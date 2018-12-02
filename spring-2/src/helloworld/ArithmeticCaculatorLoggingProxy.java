package helloworld;


import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCaculatorLoggingProxy {
    //要代理的对象
    private AtithmeticCaculator target;

    public ArithmeticCaculatorLoggingProxy(AtithmeticCaculator target) {
        this.target = target;
    }

    public AtithmeticCaculator getLoggingProxy(){
        AtithmeticCaculator proxy = null;

        //代理对象由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        //代理对象的类型即其中有哪些方法
        Class []interfaces = new Class[]{AtithmeticCaculator.class};
        //当调用代理对象其中的方法时，执行该代码
        InvocationHandler h = new InvocationHandler() {
            /**
             *
             * @param proxy:正在返回的那个代理对象，一般情况下，在invoke方法中不使用该对象
             * @param method：正在调用的方法
             * @param args  调用方法时传入的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methdoName = method.getName();
                // 日志
                System.out.println("The method" +methdoName+"begin with" + Arrays.asList(args));
                // 调用目标方法
                Object res = null;
                try {
                    // 前置通知
                    res = method.invoke(target, args);
                    // 返回通知，返回通知可以访问到方法的返回值
                }catch (Exception e){
                    e.printStackTrace();
                    // 异常通知，可以访问到方法出现的异常
                }
                //后置通知，因为方法可能会出异常所以访问不到方法的返回值

                //日志
                System.out.println("The method" +methdoName + "end with" + res);
                return 0;
            }
        };
        proxy = (AtithmeticCaculator) Proxy.newProxyInstance(loader,interfaces,h);

        return proxy;
    }
}
