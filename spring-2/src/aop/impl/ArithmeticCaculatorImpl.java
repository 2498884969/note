package aop.impl;


import org.springframework.stereotype.Component;

@Component
public class ArithmeticCaculatorImpl implements AtithmeticCaculator {
    @Override
    public int add(int i, int j) {
        return (i+j);
    }

    @Override
    public int sub(int i, int j) {
        return (i-j);
    }

    @Override
    public int mul(int i, int j) {
        return (i*j);
    }

    @Override
    public int div(int i, int j) {
        return (i/j);
    }
}
