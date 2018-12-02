package aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 可以使用@Order(1)来指定切面的优先级，数值小的优先级高
 */
@Order(1)
@Aspect
@Component
public class ValidationAspect {

    @Before(value = "execution(public int aop.impl.AtithmeticCaculator.*(int, int))")
    public void validateArgs(JoinPoint joinPoint){
        System.out.println("Validate:" + Arrays.asList(joinPoint.getArgs()));
    }
}
