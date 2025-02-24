package com.ioc.demo.test;

import com.bean.MyBean;
import com.bean.MyFactoryBean;
import com.ioc.wang.BookService;
import com.ioc.wang.Config;
import com.ioc.demo.Book;
import com.ioc.demo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = context.getBean("wang", User.class);
        System.out.println(user);
        user.add();
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        Book book1 = context.getBean("book1", Book.class);
        Book book2 = context.getBean("book2", Book.class);
        System.out.println(book1.toString());
        System.out.println(book2.toString());
    }

    @Test
    public void testPNamespace() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");
        Book bookP = context.getBean("bookP", Book.class);
        System.out.println(bookP.toString());
    }

    @Test
    public void testAnnotation(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-context.xml");
        BookService bookService = applicationContext.getBean("bookService", BookService.class);
        System.out.println(bookService);
        bookService.addBook();
    }

    @Test
    public void testAnnotationConfig(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        BookService bookService = applicationContext.getBean("bookService", BookService.class);
        System.out.println(bookService);
        bookService.addBook();
    }

    @Test
    public void testFactoryBean() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("factory_beans.xml");
        MyFactoryBean myFactoryBean = context.getBean("&myBean", MyFactoryBean.class);
        MyBean myBean = context.getBean("myBean", MyBean.class);

        System.out.println(myFactoryBean.getObject());
        System.out.println(myFactoryBean.getObject());
        System.out.println(myBean);
    }

}
