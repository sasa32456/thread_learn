package com.n33.jvm.learn.classloader.chapther1;

import java.util.concurrent.atomic.AtomicBoolean;


/**
* <clinit>初始化时保证线程安全
*
* @author N33
* @date 2019/5/13
*/
public class ClientThreadTest {
    public static void main(String[] args) {

        new Thread(SimpleObject::new).start();

        new Thread(SimpleObject::new).start();
    }

    static class SimpleObject {

        private static AtomicBoolean init = new AtomicBoolean(true);

        static {
            System.out.println(Thread.currentThread().getName()+" I will be initial.");
            while (init.get()) {

            }
            System.out.println(Thread.currentThread().getName()+" I an finished inital.");
        }
    }


}
