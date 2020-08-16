package com.aop;

import org.springframework.stereotype.Component;

@Component
public class User {
    public int add(int a, int b) {
        System.out.println("a + b 执行了");
        return a + b;
    }

    public int subtract(int a, int b) {
        System.out.println("a - b 执行了");
        return a - b;
    }
}
