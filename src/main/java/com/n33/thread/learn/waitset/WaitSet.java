package com.n33.thread.learn.waitset;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * 线程休息室，虚拟概念
 *
 * @author N33
 * @date 2019/4/20
 */
public class WaitSet {

    private static final Object LOCK = new Object();

    /**
     * 判断是否还是要输出Begin
     * 有记录，会接着执行
     */
    private static void work() {
        synchronized (LOCK) {
            System.out.println("Begin ...");
            try {
                System.out.println("Thread will coming.");
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread will out.");
        }
    }

    /**
     * This method causes the current thread (call it <var>T</var>) to
     * place itself in the wait set for this object and then to relinquish
     * any and all synchronization claims on this object. Thread <var>T</var>
     * becomes disabled for thread scheduling purposes and lies dormant
     * until one of four things happens:
     * 此方法导致当前线程 (call it <var>T</var>) 至
     * 将自己置于此对象的等待集中，然后放弃
     * 此对象的任何和所有同步声明. Thread <var>T</var>
     * 因线程调度而被禁用 并处于休眠状态lies dormant谎言休眠
     * 直到发生以下四件事之一：.........
     * <p>
     * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
     * <p>
     * 1.所有对象都会有一个wait set，用来存放该对象wait后进入block状态的线程
     * 2.线程被notify之后，不一定立即得到执行
     * 3.线程从wait set中被唤醒顺序不一定是FIFO.
     * 4.线程被唤醒后，依旧要接着获取锁
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                work();
            }
        }.start();

        Thread.sleep(1_000);
        synchronized (LOCK) {
            LOCK.notify();
        }
/*
不加synchronized (LOCK) 唤醒会出现异常,非法监视状态异常
Exception in thread "main" java.lang.IllegalMonitorStateException
	at java.lang.Object.notify(Native Method)
	at com.n33.thread.learn.waitset.WaitSet.main(WaitSet.java:62)
 */


        /*IntStream.rangeClosed(1, 10).forEach(i ->
                new Thread(String.valueOf(i)) {
                    @Override
                    public void run() {
                        synchronized (LOCK) {
                            try {
                                Optional.of(Thread.currentThread().getName() + " will come to wait set.").ifPresent(System.out::println);
                                LOCK.wait();
                                Optional.of(Thread.currentThread().getName() + " will leave to wait set.").ifPresent(System.out::println);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start()
        );

        Thread.sleep(3_000);

        IntStream.rangeClosed(1,10).forEach(i -> {
            synchronized (LOCK) {
                LOCK.notify();
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });*/


    }
}
