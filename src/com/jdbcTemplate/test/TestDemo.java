package com.jdbcTemplate.test;

import com.jdbcTemplate.dao.BookDao;
import com.jdbcTemplate.entity.Book;
import com.jdbcTemplate.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class TestDemo {
    @Test
    public void add() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-jdbcTemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book(1,"Java","高斯林");
        bookService.add(book);
    }

    @Test
    public void update() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-jdbcTemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book(1,"Java","高斯林2");
        bookService.update(book);
    }

    @Test
    public void delete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-jdbcTemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.delete(1);
    }

    @Test
    public void findById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-jdbcTemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = bookService.findById(2);
        System.out.println(book);
    }

    @Test
    public void countAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-jdbcTemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        int num = bookService.count();
        System.out.println(num);
    }

    @Test
    public void findAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-jdbcTemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Book> list = bookService.findAll();
        System.out.println(list);
    }

    @Test
    public void batchInsert() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-jdbcTemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.batchInsert(Arrays.asList(new Book(5,"Java5", "Author5"), new Book(6,"Java6", "Author6")));
    }

    @Test
    public void batchUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-jdbcTemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.batchUpdate(Arrays.asList(new Book(5,"Java5-5", "Author5-5"), new Book(6,"Java6-6", "Author6-6")));
    }

    @Test
    public void batchDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-jdbcTemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.batchDelete(Arrays.asList(5,6));
    }
}
