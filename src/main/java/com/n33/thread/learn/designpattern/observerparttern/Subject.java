package com.n33.thread.learn.designpattern.observerparttern;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public void setState(int state) {
        if (state == this.state) {
            return;
        }
        this.state = state;
        notifyAllObserver();
    }

    public int getState() {
        return state;
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObserver() {
        observers.stream().forEach(Observer::update);
    }

}
