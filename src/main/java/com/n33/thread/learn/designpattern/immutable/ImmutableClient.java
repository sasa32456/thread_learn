package com.n33.thread.learn.designpattern.immutable;

import java.util.stream.IntStream;

public class ImmutableClient {
    public static void main(String[] args) {

        final Person person = new Person("Alex", "GuanSu");

        IntStream.range(0, 5).forEach(value -> new UsePersonThread(person).start());

    }
}
