package com.n33.jvm.learn.classloader.chapther4;

import java.io.*;

import static com.n33.jvm.learn.classloader.chapther4.EncryptUtils.ENCRYPT_FACTOR;

public class DecryptClassLoader extends ClassLoader {

    private final static String DEFAULT_DIR = "F:\\IdeaProjectsLearn\\zzz\\classloader3";

    private String dir = DEFAULT_DIR;

    public DecryptClassLoader() {
        super();
    }

    public DecryptClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        File classFile = new File(dir, classPath + ".class");

        if (!classFile.exists()) {
            throw new ClassNotFoundException("The Class " + name + " not found under directory [" + dir + "]");
        }

        byte[] classBytes = loadClassBytes(classFile);

        if (null == classBytes || classBytes.length == 0) {
            throw new ClassNotFoundException("The Class " + name + " failed");
        }

        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    private byte[] loadClassBytes(File classFile) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(classFile)
        ) {
            int data;
            while ((data = fis.read()) != -1) {
                baos.write(data ^ ENCRYPT_FACTOR);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

}
