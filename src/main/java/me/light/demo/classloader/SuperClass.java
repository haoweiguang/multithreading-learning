package me.light.demo.classloader;

/**
 * 被动使用类字段演示一：
 * 通过子类引用父类的静态字段，不会导致子类初始化
 * @author light.hao
 * @date 2019/3/11 下午3:11
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}



