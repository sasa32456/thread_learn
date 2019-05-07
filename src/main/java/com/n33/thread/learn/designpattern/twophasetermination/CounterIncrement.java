package com.n33.thread.learn.designpattern.twophasetermination;

import java.util.Random;

/**
 * 二阶段终结线程设计模式
 * two phase termination 两相终止
 *
 * @author N33
 * @date 2019/5/7
 */
public class CounterIncrement extends Thread {

    private volatile boolean terminated = false;

    private int counter = 0;

    private Random random = new Random(System.currentTimeMillis());


    @Override
    public void run() {

        try {
            while (!terminated) {
                System.out.println(Thread.currentThread().getName() + " " + counter++);
                Thread.sleep(random.nextInt(1000));

            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            this.clean();
        }
    }

    private void clean() {
        System.out.println("do some clean work for the second phase , current counter " + counter);

    }

    public void close() {
        this.terminated = true;
        this.interrupt();
    }

}
