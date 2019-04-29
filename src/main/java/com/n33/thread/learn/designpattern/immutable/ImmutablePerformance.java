package com.n33.thread.learn.designpattern.immutable;

/**
 * 锁优化那么好了？？？黑人问号
 *
 * @author N33
 * @date 2019/4/26
 */
public class ImmutablePerformance {

    public static void main(String[] args) throws InterruptedException {
        final long startTimestamp = System.currentTimeMillis();


        //6342单
        //16406多
        SyncObj syncObj = new SyncObj();
        syncObj.setName("Alex");

        //6367单
        //15373多
        //final ImmutableObj immutableObj = new ImmutableObj("Alex");

        final Thread t1 = new Thread(() -> {
            for (long i = 0L; i < 1000000; i++) {
                System.out.println(Thread.currentThread().getName() + " " + syncObj.toString());
                //System.out.println(Thread.currentThread().getName() + " " + immutableObj.toString());
            }
        });

        final Thread t2 = new Thread(() -> {
            for (long i = 0L; i < 1000000; i++) {
                System.out.println(Thread.currentThread().getName() + " " + syncObj.toString());
                //System.out.println(Thread.currentThread().getName() + " " + immutableObj.toString());
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        final long endTimestamp = System.currentTimeMillis();
        System.out.println(endTimestamp - startTimestamp);
    }

}

final class ImmutableObj {
    private final String name;

    public ImmutableObj(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}

class SyncObj {
    private String name;

    public synchronized void setName(String name) {
        this.name = name;
    }

    @Override
    public synchronized String toString() {
        return "[" + name + "]";
    }
}
