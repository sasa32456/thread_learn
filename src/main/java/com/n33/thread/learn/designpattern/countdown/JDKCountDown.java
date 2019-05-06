package com.n33.thread.learn.designpattern.countdown;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
* 多线程当全部完成才进行下一步
*
* @author N33
* @date 2019/5/6
*/
public class JDKCountDown {
    private static final Random random = new Random(System.currentTimeMillis());


    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(5);

        System.out.println("准备多线程处理任务");
        //The first phase.

        IntStream.rangeClosed(1, 5).forEach(i ->
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "is working.");
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            },String.valueOf(i)).start()
        );

        latch.await();


        //The Second phase.
        System.out.println("多线程任务全部结束，准备第二阶段任务");
        System.out.println("..................");
        System.out.println("FINISH");




    }
}
