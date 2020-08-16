package com.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        System.out.println("执行方法");
        int c = a/b;
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        System.out.println("a - b 执行了");
        return a - b;
    }
}
