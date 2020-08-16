package com.transaction.test;

import com.transaction.config.TxConfig;
import com.transaction.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TxTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-transaction1.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.transfer();
    }

    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-transaction2.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.transfer();
    }

    @Test
    public void test3(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.transfer();
    }
}
