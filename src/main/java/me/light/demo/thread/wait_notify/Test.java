package me.light.demo.thread.wait_notify;

/**
 * @author light.hao
 * @date 2019/11/7 5:10 PM
 */
//测试
public class Test {
    public static void main(String[] args) {
        MyList service = new MyList();
        ThreadA a = new ThreadA(service, "A");
        ThreadB b = new ThreadB(service, "B");

        a.start();
        b.start();
    }
}
