package com.n33.thread.learn.designpattern.activeobject;

public class MakerClientThread extends Thread {

    private final ActiveObject activeObject;

    private final char fillChar;

    public MakerClientThread( ActiveObject activeObject,String name) {
        super(name);
        this.activeObject = activeObject;
        this.fillChar = name.charAt(0);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                final Result result = activeObject.makeString(i + 1, fillChar);
                Thread.sleep(20);
                final String value = (String) result.getResultValue();
                System.out.println(Thread.currentThread().getName() + ": value=" + value);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
