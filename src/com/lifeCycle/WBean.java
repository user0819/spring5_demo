package com.lifeCycle;

import org.springframework.stereotype.Component;

@Component
public class WBean {

    public WBean() {
        System.out.println("WBean constructor called");
    }

}
