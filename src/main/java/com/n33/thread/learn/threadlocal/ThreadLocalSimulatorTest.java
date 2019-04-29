package com.n33.thread.learn.threadlocal;

import java.util.Random;

/**
* 始终以当前线程作为key
*
* @author N33
* @date 2019/4/30
*/
public class ThreadLocalSimulatorTest {
    private final static ThreadLocalSimulator<String> threadLocalSimulator = new ThreadLocalSimulator<String>(){
        @Override
        public String initialValue() {
            return "Alex";
        }
    };

    //seed
    private final static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {

        final Thread t1 = new Thread(() -> {
            threadLocalSimulator.set("Thread-T1");
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println(Thread.currentThread().getName() + " " + threadLocalSimulator.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        final Thread t2 = new Thread(() -> {
            threadLocalSimulator.set("Thread-T2");
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println(Thread.currentThread().getName() + " " + threadLocalSimulator.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("======================");
        System.out.println(Thread.currentThread().getName() + " " + threadLocalSimulator.get());
    }
}
