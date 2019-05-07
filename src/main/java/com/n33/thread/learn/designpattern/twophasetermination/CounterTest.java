package com.n33.thread.learn.designpattern.twophasetermination;

public class CounterTest {
    public static void main(String[] args) throws InterruptedException {

        final CounterIncrement counterIncrement = new CounterIncrement();
        counterIncrement.start();

        Thread.sleep(10_000L);
        counterIncrement.close();

    }
}
