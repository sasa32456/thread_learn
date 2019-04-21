package com.n33.thread.learn.designpattern.singthreadedexecution;

/**
 * 单门设计
 * 共享资源，多线程
 * 优化，读写锁（另一个包）
 * @author N33
 * @date 2019/4/21
 */
public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    /**
     * ，临界值
     *
     * @param name
     * @param address
     */
    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        verify();
    }

    private void verify() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("**********BROKEN**********" + toString());
        }
    }

    @Override
    public synchronized String toString() {
        return "NO." + counter +
                " : " + name + " , " + address;
    }
}
