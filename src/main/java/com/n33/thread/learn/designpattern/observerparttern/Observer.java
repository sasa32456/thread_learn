package com.n33.thread.learn.designpattern.observerparttern;

public abstract class Observer {

    public Observer(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    protected Subject subject;

    public abstract void update();
}
