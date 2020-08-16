package com.aop;

public class BookProxy {
    public void before(){
        System.out.println("before...");
    }
    public void after(){
        System.out.println("after...");
    }
}
