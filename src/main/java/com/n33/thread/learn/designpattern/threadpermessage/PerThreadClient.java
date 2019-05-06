package com.n33.thread.learn.designpattern.threadpermessage;

import java.util.stream.IntStream;

public class PerThreadClient {
    public static void main(String[] args) {
        final MessageHandler handler = new MessageHandler();
        IntStream.rangeClosed(1, 10).forEach(i-> handler.request(new Message(String.valueOf(i))));
        handler.shutdown();
    }
}
