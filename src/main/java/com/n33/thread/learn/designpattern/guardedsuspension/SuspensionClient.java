package com.n33.thread.learn.designpattern.guardedsuspension;

public class SuspensionClient {
    public static void main(String[] args) throws InterruptedException {
        final RequestQueue queue = new RequestQueue();

        new ClientThread(queue,"Alex").start();
        final ServerThread serverThread = new ServerThread(queue);
        serverThread.start();
       // serverThread.join();

        Thread.sleep(10_000);

        serverThread.close();
    }
}
