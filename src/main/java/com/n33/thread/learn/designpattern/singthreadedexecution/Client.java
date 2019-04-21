package com.n33.thread.learn.designpattern.singthreadedexecution;

public class Client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User bj = new User("Baobao", "Beijing", gate);
        User sh = new User("Shanglao", "Shanghai", gate);
        User gz = new User("Guanglao", "Guangzhou", gate);

        bj.start();
        sh.start();
        gz.start();
    }
}
