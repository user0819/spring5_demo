package com.ioc.wang;

import org.springframework.stereotype.Component;

/**
 * 不加value属性，默认id为类名
 */
@Component
public class BookService {
    public void addBook(){
        System.out.println("买本书看看");
    }
}
