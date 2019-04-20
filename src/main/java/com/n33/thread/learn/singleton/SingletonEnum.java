package com.n33.thread.learn.singleton;

import java.util.stream.IntStream;

/**
 * 枚举实现单例
 *
 * @author N33
 * @date 2019/4/20
 */
public class SingletonEnum {

    private SingletonEnum() {
    }

    /**
     * 枚举天然单例
     * 防止反射和输入输出流的破解
     */
    private enum Singleton {
        /**
         * 基础创建
         */
        INSTANCE;

        private final SingletonEnum instance;

        /**
         * 赋予单例
         */
        Singleton() {
            this.instance = new SingletonEnum();
        }

        /**
         * 对外暴露单例获取
         *
         * @return
         */
        public SingletonEnum getInstance() {
            return instance;
        }
    }

    public static SingletonEnum getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(i -> new Thread(String.valueOf(i)) {
            @Override
            public void run() {
                System.out.println(SingletonEnum.getInstance());
            }
        }.start());
    }


}
