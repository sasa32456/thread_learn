package com.n33.thread.learn.designpattern.threadspecificstorage;

import java.util.stream.IntStream;

public class ContextTest {
    public static void main(String[] args) {

        IntStream.range(0, 5).forEach(i ->{
            new Thread(new ExecutionTask()).start();
        });
    }
}
