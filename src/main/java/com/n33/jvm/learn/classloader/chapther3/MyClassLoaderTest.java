package com.n33.jvm.learn.classloader.chapther3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

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
