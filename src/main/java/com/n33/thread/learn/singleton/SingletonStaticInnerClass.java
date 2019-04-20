package com.n33.thread.learn.singleton;

/**
* 静态内部类式单利
*
* @author N33
* @date 2019/4/20
*/
public class SingletonStaticInnerClass {

    private SingletonStaticInnerClass() {
    }

    /**
     * static 只会初始化一次，且执行顺序友好（不会还没赋值就被用）
     * 线程友好（天然线程安全）
     */
    private static class InstanceHolder{
        private final static SingletonStaticInnerClass instance = new SingletonStaticInnerClass();
    }

    public static SingletonStaticInnerClass getInstance(){
        return InstanceHolder.instance;
    }
}
