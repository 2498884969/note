package helloworld;

public class Main {

    public static void main(String[] args) {

//        AtithmeticCaculator atithmeticCaculator = null;
//        atithmeticCaculator = new ArithmeticCaculatorImpl();

        AtithmeticCaculator taget = new ArithmeticCaculatorImpl();
        AtithmeticCaculator proxy = new ArithmeticCaculatorLoggingProxy(taget).getLoggingProxy();


        int res = proxy.add(1, 2);
        System.out.println(res);

        res = proxy.div(4,2);
        System.out.println(res);
    }

}
