package com.n33.thread.learn.designpattern.producerandcunsumer;

/**
* 生产者消费者
* 
* @author N33
* @date 2019/5/4
*/
public class Message {

    private String data;

    public Message(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

}
