package me.light.demo.thread.MultithreadCommunication;

/**
 * 多线程通信
 *
 * @author light.hao
 * @date 2019/2/28 下午5:38
 */
public class demo {

    private static void demo1() {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B 开始等待 A");
                try {
                    A.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printNumber("B");
            }
        });

        A.start();
        B.start();
    }


    private static void printNumber(String threadName) {
        int i = 0;
        while (i++ < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " print: " + i);
        }
    }

    public static void main(String[] args) {
        demo1();
    }

}
