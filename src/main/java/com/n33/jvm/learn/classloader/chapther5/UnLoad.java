package com.n33.jvm.learn.classloader.chapther5;

/**
 * 类的卸载以及classLoader的卸载
 * JVM的Class只有满足以下三个条件，才能被GC回收，也就是该Class被卸载(unload)
 * 该类的实例都被GC
 * 加载该类的ClassLoader实例已经被GC
 * 该类的java.lang.Class对象没有在任何地方被引用(java.lang.Class有ClassLoader的引用，所以前者没回收之前后者不会被回收,根加载和类加载不会被回收，因为初始时会有大量伴随JVM生命周期的类存在)
 * GC的时机我们是不可控的，那么同时我们对Class的卸载也是不可控的
 *
 * @author N33
 * @date 2019/5/15
 */

public class UnLoad {
}
