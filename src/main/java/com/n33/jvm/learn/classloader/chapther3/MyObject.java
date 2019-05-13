package com.n33.jvm.learn.classloader.chapther3;

public class MyObject {
    static {
        System.out.println("My object static block.");
    }

    public String hello() {
        return "Hello World";
    }
}
