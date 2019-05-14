package com.n33.jvm.learn.classloader.chapther4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 加密类加载
 *
 * @author N33
 * @date 2019/5/14
 */
public final class EncryptUtils {

    public static final byte ENCRYPT_FACTOR = (byte) 0xff;

    private EncryptUtils() {
        //empty
    }

    public static void doEncrypt(String source, String target) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(target)
        ) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data ^ ENCRYPT_FACTOR);
            }
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //doEncrypt("F:\\IdeaProjectsLearn\\zzz\\aaa.txt","F:\\IdeaProjectsLearn\\zzz\\bbb.txt");
        //doEncrypt("F:\\IdeaProjectsLearn\\zzz\\bbb.txt","F:\\IdeaProjectsLearn\\zzz\\ccc.txt");
        doEncrypt("F:\\IdeaProjectsLearn\\zzz\\classloader3\\com\\n33\\jvm\\learn\\classloader\\chapther3\\MyObject.class", "F:\\IdeaProjectsLearn\\zzz\\classloader3\\com\\n33\\jvm\\learn\\classloader\\chapther3\\MyObject.class1");
    }

}
