package com.ioc.wang;

import org.springframework.stereotype.Controller;

/**
 * 不加value属性，默认id为类名
 */
@Controller
public class BookController {
    public void addBook() {
        System.out.println("买本书看看");
    }
}
