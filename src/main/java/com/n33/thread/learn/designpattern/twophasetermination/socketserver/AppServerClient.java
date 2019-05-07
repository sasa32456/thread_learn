package com.n33.thread.learn.designpattern.twophasetermination.socketserver;

import java.io.IOException;

public class AppServerClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        AppServer server = new AppServer(13345);
        server.start();
        System.out.println("启动...");

        Thread.sleep(5_000L);

        server.shutdown();
        System.out.println("关闭...");
    }
}
