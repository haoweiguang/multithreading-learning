package me.light.demo.thread.basic;

/**
 * @author light.hao
 * @date 2019/2/26 下午8:40
 */
public class MyRunnableTest {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
