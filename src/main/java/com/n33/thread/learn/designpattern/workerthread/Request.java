package com.n33.thread.learn.designpattern.workerthread;

public class Request {

    private final String name;

    private final int number;

    public Request(final String name, final int number) {
        this.name = name;
        this.number = number;
    }


    public void excute() {
        System.out.println(Thread.currentThread().getName() + " execute " + this);
    }


    @Override
    public String toString() {
        return "Request => No. " + number + " Name. " + name;
    }
}
