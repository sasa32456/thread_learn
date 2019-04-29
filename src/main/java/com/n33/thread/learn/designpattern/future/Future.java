package com.n33.thread.learn.designpattern.future;

public interface Future<T> {
    T get() throws InterruptedException;
}
