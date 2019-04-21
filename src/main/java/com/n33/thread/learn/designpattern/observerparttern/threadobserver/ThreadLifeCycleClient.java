package com.n33.thread.learn.designpattern.observerparttern.threadobserver;

import java.util.Arrays;

public class ThreadLifeCycleClient {

    public static void main(String[] args) {

        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1","2"));

    }
}
