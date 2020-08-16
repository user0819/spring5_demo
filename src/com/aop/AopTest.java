package com.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    @Test
    public void testAop1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-aop.xml");
        UserDao userDao = applicationContext.getBean("userDaoImpl", UserDao.class);
        userDao.add(1,2);
        //System.out.println("result:" + result);
    }

    @Test
    public void testAop2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-aop-xml.xml");
        Book book = applicationContext.getBean("book", Book.class);
        book.add();
    }

    @Test
    public void testAop3(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        UserDao userDao = applicationContext.getBean("userDaoImpl", UserDao.class);
        userDao.add(1,2);
    }
}
