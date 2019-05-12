package com.n33.jvm.learn.classloader.chapther1;

public class Singleton {
    /**
     * instance = null;
     * int x = 0;
     * int y = 0;
     *
     *instance = new Singleton();执行构造方法  ==> x=1,y=1;
     *
     * x=0;
     * y=1;//已赋值，不变
     *
     *
     *
     */
    private static Singleton instance = new Singleton();

    public static int x = 0;

    public static int y;


    /**
     * int x = 0;
     * int y = 0;
     * instance = null;
     *
     * 赋值
     *
     * x=0
     * y=0
     * instance = new Singleton();执行构造方法
     * x=1,y=1;
     *
     */
    //private static Singleton singleton = new Singleton();

    private Singleton() {
        x++;
        y++;
    }


    public static Singleton getInstance() {
        return instance;
    }


    public static void main(String[] args) {
        Singleton singleton = getInstance();
        System.out.println(singleton.x);
        System.out.println(singleton.y);
    }
}
