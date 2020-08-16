package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class UserDaoProxy2 {

    @Pointcut(value = "execution(* com.aop.UserDaoImpl.*(..))")
    public void pointcut(){}

    //前置通知
    @Before(value = "pointcut()")
    public void before(){
        System.out.println("UserDaoProxy2前置通知...");
    }
}
