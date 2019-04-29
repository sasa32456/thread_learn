package com.n33.thread.learn.designpattern.immutable;

/**
 * 不可变对象设计模式，不用加锁
 *
 * @author N33
 * @date 2019/4/26
 */
final public class Person {

    private final String name;
    private final String address;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Person(final String name, final String address) {
        this.name = name;
        this.address = address;
    }
}
