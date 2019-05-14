package com.n33.jvm.learn.classloader.chapther5;

public class RuntimePackage {
    //RuntimePackage
    //com.n33.jvm.learn.classloader.chapther5
    //Boot.Ext.App.com.n33.jvm.learn.classloader.chapther5

    //系统加载器加载
    //Boot.Ext.App.com.n33.jvm.learn.classloader.chapther5.SimpleClassLoaderTest
    //自己的加载器加载,这两者之间无法互相访问
    //Boot.Ext.SimpleClassLoader.com.n33.jvm.learn.classloader.chapther5.SimpleClassLoaderTest


    public static void main(String[] args) throws Exception {
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader();
        final Class<?> aClass = simpleClassLoader.loadClass("com.n33.jvm.learn.classloader.chapther5.SimpleObject");
        //System.out.println(aClass.getClassLoader());

        /**
         * Exception in thread "main" java.lang.ClassCastException: com.n33.jvm.learn.classloader.chapther5.SimpleObject cannot be cast to com.n33.jvm.learn.classloader.chapther5.SimpleObject
         * 	at com.n33.jvm.learn.classloader.chapther5.RuntimePackage.main(RuntimePackage.java:19)
         * 	系统加载器无法看到儿子的内容--不同加载器之间无法相互访问
         */
        final SimpleObject simpleObject = (SimpleObject) aClass.newInstance();

    }


}
