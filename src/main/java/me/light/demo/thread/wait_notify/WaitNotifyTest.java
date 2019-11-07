package me.light.demo.thread.wait_notify;

/**
 * @author light.hao
 * @date 2019/11/7 5:34 PM
 */
public class WaitNotifyTest {
    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();

        Thread.sleep(2000);

        thread2.start();

    }

    static class Thread1 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                String threadName = Thread.currentThread().getName();
                System.out.println("线程" + threadName + "获取到了锁...");

                try {
                    System.out.println("线程" + threadName + "阻塞并释放锁...");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + threadName + "执行完成...");
            }
        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                String threadName = Thread.currentThread().getName();
                System.out.println("线程" + threadName + "获取到了锁...");
                object.notify();
                System.out.println("线程" + threadName + "唤醒了正在wait的线程...");
            }
            System.out.println("线程" + Thread.currentThread().getName() + "执行完成...");
        }
    }
}

