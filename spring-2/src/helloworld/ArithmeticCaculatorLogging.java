package helloworld;

public class ArithmeticCaculatorLogging implements AtithmeticCaculator {
    @Override
    public int add(int i, int j) {
        System.out.println("the method add begins with[" +i+","+j+"]");
        return (i+j);

    }

    @Override
    public int sub(int i, int j) {
        System.out.println("the method sub begins with[" +i+","+j+"]");
        return (i-j);
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("the method mul begins with[" +i+","+j+"]");
        return (i*j);
    }

    @Override
    public int div(int i, int j) {
        System.out.println("the method div begins with[" +i+","+j+"]");
        return (i/j);
    }
}
