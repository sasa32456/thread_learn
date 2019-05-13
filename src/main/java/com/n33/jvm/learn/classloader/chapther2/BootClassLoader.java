package com.n33.jvm.learn.classloader.chapther2;

/**
 * 根(bootdtrsp)加载器,没有父加载器，从系统属性sun.boot.class.path所指定的目录中加载类库，实现依赖底层操作系统，没有继承java.lang.ClassLoader
 *
 * 扩展(Extension)类加载器，从java.ext.dirs子目录下加载类库，纯java，是java.lang.ClassLoader子类
 *
 * 系统(System)类加载器，父类为扩展加载器，从环境变量classpath或系统属性java.class.path加载，是用户自定义类加载器的默认父加载器，是纯java类，是java.lang.ClassLoader子类
 *
 * 先由父类先找，所以自己写的String无法覆盖
 *
 *
 *
 * @author N33
 * @date 2019/5/13
 */
public class BootClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {


        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));


        final Class<?> klass = Class.forName("com.n33.jvm.learn.classloader.chapther2.SimpleObject");
        System.out.println(klass.getClassLoader());//AppClassLoader
        System.out.println(klass.getClassLoader().getParent());//ExtClassLoader
        System.out.println(klass.getClassLoader().getParent().getParent());//null



        final Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz);
        System.out.println(clazz.getClassLoader());//null
    }
}

