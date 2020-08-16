package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserDaoProxy {

    @Pointcut(value = "execution(* com.aop.UserDaoImpl.*(..))")
    public void pointcut(){}

    //前置通知
    @Before(value = "pointcut()")
    public void before(){
        System.out.println("前置通知...");
    }

    //在方法执行之后,无论方法是否正常完成（finally）
    @After(value = "pointcut()")
    public void after(){
        System.out.println("after...");
    }

    //在方法返回值之后
    @AfterReturning(value = "pointcut()")
    public void afterReturning(){
        System.out.println("afterReturning...");
    }

    //在方法返回抛出异常之后
    @AfterThrowing(value = "pointcut()")
    public void afterThrowing(){
        System.out.println("afterThrowing...");
    }

    //环绕通知
    @Around(value = "pointcut()")
    public int around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around之前...");
        int i = (int) proceedingJoinPoint.proceed();
        System.out.println("around之后...");
        return i;
    }
}
