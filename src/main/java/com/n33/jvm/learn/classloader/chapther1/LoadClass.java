package com.n33.jvm.learn.classloader.chapther1;

/**
 * 类的加载简单来说，就是将class文件中的二进制数据读取到内存中，
 * 将其放到方法区中，然后在堆中创建一个java.lang.Class对象，
 * 用来封装在方法区中的数据结构
 * <p>
 * 加载类的方式
 * 1.本地磁盘中直接加载
 * 2.内存中直接加载
 * 3.通过网络加载
 * 4.从zip，jar等归档文件中加载.class文件
 * 5.数据库中提取.class文件
 * 6.动态编译
 * <p>
 * <p>
 * 验证：
 * VerifyError
 * 一、文件格式验证
 * 1.魔术因子是否正确：0xCAFEBABE
 * 2.主从版本号是否符合当前虚拟机
 * 3.常量池中常量类型是不是不支持
 * 4.etc
 * <p>
 * 二、元数据验证
 * 1.是否有父类
 * 2.父类是不是允许继承
 * 3.是否实现了抽象方法
 * 4.是否覆盖了父类的final字段
 * 5.其他的语义检查
 * <p>
 * 三、字节码验证
 * 1.主要进行数据流和控制流的分析，不会出现这种情况，在操作栈中放置了一个int类型，却给了一个long的数据
 * <p>
 * 四、符号引用验证
 * 1.调用一个不从在的方法字段等
 * <p>
 * 准备
 * <p>
 * 初始化 clinit 初始化class init
 * 静态块中只能访问定义在静态块之前的变量，定义在后的，只能赋值，不能访问
 * 初始化时父类优先
 * 虚拟机有义务保证<clinit>的线程安全
 *
 *
 *
 * @author N33
 * @date 2019/5/12
 */
public class LoadClass {

    public static void main(String[] args) {

//        MyObject myObject1 = new MyObject();
//        MyObject myObject2 = new MyObject();
//        MyObject myObject3 = new MyObject();
//
//
//        System.out.println(myObject1.getClass() == myObject2.getClass());
//        System.out.println(myObject1.getClass() == myObject3.getClass());
//        System.out.println(myObject3.getClass() == myObject2.getClass());
//
//        System.out.println(MyObject.x);

        System.out.println(Sub.x);
    }

}

class MyObject {
    public static int x = 10;

    static {
        System.out.println(x);
        x = 10 + 1;

        // y = 200;
        //System.out.println(y);//illegal forward reference 向前回滚的引用
    }

    //private static int y = 20;
}


class Parent {
    static {
        System.out.println("parent");
    }
}


class Sub extends Parent{

    public static int x = 100;

    static {
        System.out.println("child");

    }
}
