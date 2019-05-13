package com.n33.jvm.learn.classloader.chapther3;

/**
* 测试对象
* 
* @author N33
* @date 2019/5/14
*/
public class MyObject {
    static {
        System.out.println("My object static block.");
    }

    public String hello() {
        return "Hello World";
    }
}
