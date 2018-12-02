package aop.impl;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


//1>.把这个类声明为一个切面：需要把该类放到IOC容器中、再声明为一个切片
@Order(2)
@Component
@Aspect
public class LoggingAspect {

    /**
     * 定义一个方法，用于切入点表达式，一般地，该方法中不需要再添入其他代码。
     * 使用@Pointcut来声明切入点表达式
     * 后面其他通知使用方法名来引用当前的切入点表达式
     */
    @Pointcut("execution(public int aop.impl.AtithmeticCaculator.*(int, int))")
    public void declareJointPointExpression(){}

    // 2>.声明该方法是一个前置通知
    @Before("declareJointPointExpression()")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+ methodName +" begins with" + args);
    }
//    // 3>.在目标方法执行后，无论是否发生异常，执行的通知。
//    // i. 在后置通知中无法访问函数的返回结果，执行结果需要在返回通知中进行访问
//    @After("declareJointPointExpression()")
//    public void afterMethod(JoinPoint joinPoint){
//        String methodName = joinPoint.getSignature().getName();
//        List<Object> args = Arrays.asList(joinPoint.getArgs());
//        System.out.println("The method "+ methodName +" ends" );
//    }

    /**
     * 在方法正常执行结束后执行的代码
     * 返回通知是可以访问到方法的返回值得
     * @param joinPoint
     */
    @AfterReturning(value = "execution(public int aop.impl.AtithmeticCaculator.*(int, int))",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+ methodName +" ends with " + result );
    }

    /**
     * 目标方法出现异常时会执行的代码，可以访问异常对象且可以在出现特定异常时，执行通知代码
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "execution(public int aop.impl.AtithmeticCaculator.*(int, int))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, NullPointerException ex){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+ methodName +" occurs with " +ex );
    }

    /**
     * 环绕通知需携带ProceedingJoinPoint类型的参数
     * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint 可决定是否执行目标方法。
     * 且环绕通知必须有返回值，返回值必须为目标方法的返回值
     * @param pjd
     */
//    @Around(value = "execution(public int aop.AtithmeticCaculator.*(int, int))")
//    public Object aroundMethod(ProceedingJoinPoint pjd){
//
//        Object result = null;
//        String methodName = pjd.getSignature().getName();
//
//        //执行目标方法
//        try{
//            //前置通知
//            System.out.println("The method" + methodName + "begin with "+ Arrays.asList(pjd.getArgs()));
//            result = pjd.proceed();
//            //返回通知
//            System.out.println("The method "+methodName+" ends with " + result);
//        }catch (Throwable e){
////            e.printStackTrace();
//            System.out.println("The method "+methodName+" occurs exception: " + e);
//            throw new RuntimeException(e);
//        }
//            // 后置通知
//            System.out.println("The Method "+methodName+" ends");
//        return result;
//    }

}
