package com.n33.thread.learn.designpattern.threadpermessage;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageHandler {
    private final static Random random = new Random(System.currentTimeMillis());

    private final static ExecutorService executor = Executors.newFixedThreadPool(5);

    public void request(Message message) {
        executor.execute(()->{
            String value = message.getValue();
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println("The message will be handle by " + Thread.currentThread().getName()+" " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        new Thread(()->{
//           String value = message.getValue();
//            try {
//                Thread.sleep(random.nextInt(1000));
//                System.out.println("The message will be handle by" + Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }

    public void shutdown(){
        executor.shutdown();
    }

}
