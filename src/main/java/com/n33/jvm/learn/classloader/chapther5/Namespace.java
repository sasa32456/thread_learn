package com.n33.jvm.learn.classloader.chapther5;

/**
 * 类加载的命名空间
 * 每个类的加载器都有子命名空间，命名空间由该加载器及其所有父类所加载的类组成的
 * 在同一个命名空间中，不会出现完整的名字
 *
 * @author N33
 * @date 2019/5/14
 */
public class Namespace {
    public static void main(String[] args) throws ClassNotFoundException {
        final ClassLoader classLoader = Namespace.class.getClassLoader();
        final Class<?> aClass = classLoader.loadClass("java.lang.String");
        final Class<?> bClass = classLoader.loadClass("java.lang.String");

        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());

        /**
         * 例如MyClassLoaderTest2
         * 命名空间是不同的
         */
    }
}
