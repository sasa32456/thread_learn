package com.n33.jvm.learn.classloader.chapther4;

import com.n33.jvm.learn.classloader.chapther3.MyClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {

        DecryptClassLoader classLoader = new DecryptClassLoader();
        //MyClassLoader classLoader = new MyClassLoader();
        //classLoader.setDir("F:\\IdeaProjectsLearn\\zzz\\classloader3");
        final Class<?> aClass = classLoader.loadClass("com.n33.jvm.learn.classloader.chapther3.MyObject");
        System.out.println(aClass);
        System.out.println(aClass.getClassLoader());

        /**
         * 成功了，因该是不能在idea内或者项目内吧
         */
        Object obj = aClass.newInstance();
        Method method = aClass.getMethod("hello", new Class<?>[]{});
        Object result = method.invoke(obj, new Object[]{});
        System.out.println(result);
    }
}
