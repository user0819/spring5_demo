package com.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyDemo {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        UserDao userDao2 = (UserDao) Proxy.newProxyInstance(JdkProxyDemo.class.getClassLoader(), new Class[]{UserDao.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("执行方法前...");
                Object result = method.invoke(userDao, args);
                System.out.println("执行方法后...");
                return result;
            }
        });
        int result = userDao2.add(1, 2);
        System.out.println(result);

        int result2 = userDao2.subtract(1, 2);
        System.out.println(result2);
    }
}
