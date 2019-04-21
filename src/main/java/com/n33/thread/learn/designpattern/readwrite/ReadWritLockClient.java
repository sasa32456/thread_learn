package com.n33.thread.learn.designpattern.readwrite;

public class ReadWritLockClient {


    public static void main(String[] args) {

        final SharedData sharedData = new SharedData(10);
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();


        new WriteWorker(sharedData, "abcdefghijk").start();
        new WriteWorker(sharedData, "ABCDEFGHIJK").start();


    }
}
