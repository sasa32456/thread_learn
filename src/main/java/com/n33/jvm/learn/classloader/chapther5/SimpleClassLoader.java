package com.n33.jvm.learn.classloader.chapther5;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 自定义类加载器
 *
 * @author N33
 * @date 2019/5/13
 */
public class SimpleClassLoader extends ClassLoader {

    private final static String DEFAULT_DIR = "F:\\IdeaProjectsLearn\\zzz\\revert";

    private String dir = DEFAULT_DIR;

    private String classLoaderName;

    public SimpleClassLoader() {
        super();
    }

    public SimpleClassLoader(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public SimpleClassLoader(String classLoaderName, ClassLoader parent) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }


    /**
     * xxx.xxx.xxx.xxx.AAA
     * xxx/xxx/xxx/xxx/AAA.class
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        File classFile = new File(dir, classPath + ".class");
        if (!classFile.exists()) {
            throw new ClassNotFoundException("The class " + name + " not found under " + dir);
        }

        byte[] classBytes = loadClassBytes(classFile);
        if (null == classBytes || classBytes.length == 0) {
            throw new ClassNotFoundException("load the class " + name + " failed");
        }

        return this.defineClass(name, classBytes, 0, classBytes.length);

    }

    /**
     * 重写loadClass ，子先找，父后找
     *
     * @param name
     * @param resolve
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> clazz = null;
        /**
         * Exception in thread "main" java.lang.ClassFormatError: Incompatible magic value 0 in class file com/n33/jvm/learn/classloader/chapther5/SimpleObject
         * 	at java.lang.ClassLoader.defineClass1(Native Method)
         * 	at java.lang.ClassLoader.defineClass(ClassLoader.java:763)
         * 	at java.lang.ClassLoader.defineClass(ClassLoader.java:642)
         * 	at com.n33.jvm.learn.classloader.chapther5.SimpleClassLoader.findClass(SimpleClassLoader.java:58)
         * 	at com.n33.jvm.learn.classloader.chapther5.SimpleClassLoader.loadClass(SimpleClassLoader.java:73)
         * 	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
         * 	at com.n33.jvm.learn.classloader.chapther5.SimpleClassLoaderTest.main(SimpleClassLoaderTest.java:12)
         *
         *
         * 	java的还是要父先找
         */
        if (name.startsWith("java.")) {
            try {
                ClassLoader system = ClassLoader.getSystemClassLoader();
                clazz = system.loadClass(name);
                if (clazz != null) {
                    if (resolve) {
                         resolveClass(clazz);
                    }
                    return clazz;
                }
            } catch (Exception e) {
                //ignore
            }
        }

        try {
            clazz = findClass(name);
        } catch (Exception e) {

        }

        if (clazz == null && getParent() != null) {
            getParent().loadClass(name);
        }

        return clazz;
    }

    private byte[] loadClassBytes(File classFile) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(classFile)
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer,0,len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getClassLoaderName() {
        return classLoaderName;
    }

    public void setClassLoaderName(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }
}
