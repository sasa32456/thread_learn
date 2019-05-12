package com.n33.jvm.learn.classloader.chapther1;

import java.util.Random;

public class ClassActiveUse {

    static {
        System.out.println("ClassActiveUse");
    }


    public static void main(String[] args) throws ClassNotFoundException {

//        new Obj();
//        System.out.println(I.a);
//        System.out.println(Obj.salary);
//        Obj.printSalary();

//        Class.forName("com.n33.jvm.learn.classloader.chapther1.Obj");

//        System.out.println(Child.age);//先父类，后子类

//        System.out.println(Child.salary);//子类不会被初始化，父类会被初始化


//        Obj[] arrays = new Obj[10];//通过数组不会被初始化

        //final一开始被放入常量池，不会被初始化
        System.out.println(Obj.salary);
        //编译器无法处理，会被初始化
        System.out.println(Obj.x);


    }
}


class Obj {

    public final static long salary = 100000L;

    public final static int x = new Random().nextInt(100);

    static {
        System.out.println("Obj 被初始化.");
    }

    public static void printSalary() {
        System.out.println("=============Obj=printSalary");
    }
}

class Child extends Obj {

    public static int age = 32;

    static {
        System.out.println("Child 被初始化.");
    }
}


interface I {

    //final static int a = 10;//默认final static
    int a = 10;
}


//访问某个类或者接口的静态变量，或者对该静态变量进行赋值操作
//1.对某个类的静态变量那个读写   -> class
//2.对接口中的静态变量进行读写   -> interface
