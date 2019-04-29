package com.n33.thread.learn.designpattern.guardedsuspension;

public class Request {
    private String value;

    public Request(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
