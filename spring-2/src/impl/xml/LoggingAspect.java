package impl.xml;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;



public class LoggingAspect {

    public void declareJointPointExpression(){}


    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+ methodName +" begins with" + args);
    }

    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+ methodName +" ends" );
    }


    public void afterReturning(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+ methodName +" ends with " + result );
    }


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
