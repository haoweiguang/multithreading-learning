package me.light.demo.classLoader;

/**
 * @author light.hao
 * @date 2019/3/11 下午3:16
 */
public class NotInitialization {
    public static void main(String[] args) {
        /**
         *被动使用类字段演示一：
         * 非主动使用类字段演示
         **/
        System.out.println("演示一");
        System.out.println(SubClass.value);

        /**
         *被动使用类字段演示二：
         *通过数组定义来引用类，不会触发此类的初始化
         **/
        System.out.println("演示二");
        SuperClass[] superClasses = new SuperClass[10];

        /**
         *被动使用类字段演示三：
         **/
        System.out.println("演示三");
        System.out.println(ConstClass.HELLOWORLD);
    }
}
