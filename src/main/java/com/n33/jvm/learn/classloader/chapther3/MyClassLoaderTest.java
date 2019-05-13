package com.n33.jvm.learn.classloader.chapther3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

/**
 * 自爆，难受
 * Exception in thread "main" java.lang.ClassFormatError: Incompatible magic value 0 in class file com/n33/jvm/learn/classloader/chapther3/MyObject
 * 	at java.lang.ClassLoader.defineClass1(Native Method)
 * 	at java.lang.ClassLoader.defineClass(ClassLoader.java:763)
 * 	at java.lang.ClassLoader.defineClass(ClassLoader.java:642)
 * 	at com.n33.jvm.learn.classloader.chapther3.MyClassLoader.findClass(MyClassLoader.java:58)
 * 	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
 * 	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
 * 	at com.n33.jvm.learn.classloader.chapther3.MyClassLoaderTest.main(MyClassLoaderTest.java:8)
 */
        MyClassLoader classLoader = new MyClassLoader("MyClassLoader");
         Class<?> aClass = classLoader.loadClass("com.n33.jvm.learn.classloader.chapther3.MyObject");
        System.out.println(aClass);
        System.out.println(aClass.getClassLoader());

        Object obj = aClass.newInstance();
         Method method = aClass.getMethod("hello", new Class<?>[]{});
         Object result = method.invoke(obj, new Object[]{});
        System.out.println(result);
    }
}
