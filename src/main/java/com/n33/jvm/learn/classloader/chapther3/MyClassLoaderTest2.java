package com.n33.jvm.learn.classloader.chapther3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 类加载器的委托是优先交给父加载器去尝试加载
 * 父加载器和子加载器是一种包装关系，或者包含关系
 *
 * @author N33
 * @date 2019/5/14
 */
public class MyClassLoaderTest2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        MyClassLoader classLoader1 = new MyClassLoader("MyClassLoader-1");
//        MyClassLoader classLoader2 = new MyClassLoader(classLoader1, "MyClassLoader-2");
        MyClassLoader classLoader2 = new MyClassLoader("MyClassLoader-2");


        classLoader2.setDir("F:\\IdeaProjectsLearn\\zzz\\classloader2");


        Class<?> aClass = classLoader1.loadClass("com.n33.jvm.learn.classloader.chapther3.MyObject");
        System.out.println(aClass.hashCode());
        Class<?> aClass2 = classLoader2.loadClass("com.n33.jvm.learn.classloader.chapther3.MyObject");
        System.out.println(aClass2.hashCode());


//        System.out.println(aClass);
//        System.out.println(((MyClassLoader) aClass.getClassLoader()).getClassLoaderName());

    }
}
