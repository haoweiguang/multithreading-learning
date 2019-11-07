package me.light.demo.classloader;

/**
 * @author light.hao
 * @date 2019/3/11 下午3:16
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}

