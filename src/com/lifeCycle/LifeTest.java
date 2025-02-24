package com.lifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(LifeConfig.class);
        LifeBean myBean = context.getBean(LifeBean.class);
        myBean.performTask();
        ((AnnotationConfigApplicationContext) context).close();
    }
}
