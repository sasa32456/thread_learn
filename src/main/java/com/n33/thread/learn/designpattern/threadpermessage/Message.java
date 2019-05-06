package com.n33.thread.learn.designpattern.threadpermessage;

/**
* 每一个请求对应一个线程
* 
* @author N33
* @date 2019/5/7
*/
public class Message {
    private final String value;

    public Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
