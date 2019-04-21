package com.n33.thread.learn.designpattern.observerparttern;

public class BinaryObserver extends Observer {


    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
