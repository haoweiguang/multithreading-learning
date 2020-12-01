package me.light.demo.abstractclass;

/**
 * @author light.hao
 * @date 2020/8/10 2:12 下午
 */
public class AbstractClassMain {
    public static void main(String[] args) {
        Person person = new Student();
        person.before();
        person.hello();
    }
}
