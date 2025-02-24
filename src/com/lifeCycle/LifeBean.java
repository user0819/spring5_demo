package com.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 生命周期：
 * 1、实例化
 * 2、依赖注入
 * 3、初始化
 * 4、使用
 * 5、销毁
 *
 * 初始化几种机制：
 * 全局：BeanPostProcessor （before、after）
 * 局部：
 *  + @PostConstruct、@PreDestroy
 *  + InitializingBean
 *  + DisposableBean
 *
 * 结果：
 * LifeBean constructor                                 （1、实例化）
 * WBean constructor called                             （2、依赖注入）
 * postProcess Before Initialization                    （3、初始化 BeanPostProcessor before）
 * LifeBean @PostConstruct method                       （3、初始化 @PostConstruct）
 * LifeBean InitializingBean afterPropertiesSet method  （3、初始化 InitializingBean init ）
 * postProcess After Initialization                     （3、初始化 BeanPostProcessor after）
 * Task is being performed                              （4、使用）
 * LifeBean @PreDestroy method                          （5、销毁  @PreDestroy）
 * LifeBean DisposableBean destroy method               （5、销毁  DisposableBean destroy）
 *
 */

@Component
public class LifeBean  implements InitializingBean, DisposableBean {
    @Autowired
    private WBean wBean;

    public LifeBean() {
        System.out.println("LifeBean constructor");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("LifeBean InitializingBean afterPropertiesSet method");
    }

    @PostConstruct
    public void init() {
        System.out.println("LifeBean @PostConstruct method");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("LifeBean @PreDestroy method");
    }

    @Override
    public void destroy() {
        System.out.println("LifeBean DisposableBean destroy method");
    }

    public void performTask() {
        System.out.println("Task is being performed");
    }
}
