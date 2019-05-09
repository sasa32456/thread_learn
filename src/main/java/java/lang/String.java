package java.lang;

/**
 * 类加载分三个阶段
 *
 * 加载：查找并加载二进制数据
 *
 * 连接：
 *    -验证：确保被加载类的正确性
 *    -准备：为类的静态变量分配内存，并将其初始化为默认值
 *    -解析：八类中的符号引用变为直接引用
 *
 * 初始化：为类的静态变量赋予正确的初始值
 *
 *
 *
 *
 * @author N33
 * @date 2019/5/9
 */
public class String {

    //最先执行
    private static int i = 1;

    private int x;

    private Object object = new Object();

    public String() {
        this.x = 10;
    }

    public int getValue() {
        this.object.hashCode();
        return 1;
    }


}

//魔术因子
//00001 代表exe
//exe   -->jpg 00002误导
//class -->
