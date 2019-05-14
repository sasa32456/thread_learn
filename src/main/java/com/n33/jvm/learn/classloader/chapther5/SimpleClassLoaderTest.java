package com.n33.jvm.learn.classloader.chapther5;

/**
 * 打破双亲委托
 * 注：java.lang不会被破坏，Prohibted package name 禁止包名称
 *
 * @author N33
 * @date 2019/5/14
 */
public class SimpleClassLoaderTest {
    public static void main(String[] args) throws Exception {
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader();
        final Class<?> aClass = simpleClassLoader.loadClass("com.n33.jvm.learn.classloader.chapther5.SimpleObject");
        System.out.println(aClass.getClassLoader());

    }
}
