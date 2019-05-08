package com.n33.thread.learn.designpattern.activeobject;

/**
 * 非常重要，用到很多模式，适合反复
 *
 * @author N33
 * @date 2019/5/9
 */
public class DisplayClientThread extends Thread {
    private final ActiveObject activeObject;

    public DisplayClientThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
    }


    @Override
    public void run() {
        for (int i = 0; true; i++) {
            try {
                String text = Thread.currentThread().getName() + "=>" + i;
                activeObject.displayString(text);
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
