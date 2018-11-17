package me.light.demo.ImplByTread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable running");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();


        //匿名类的实现方式
        Runnable myRunnable1 = new Runnable() {
            public void run() {
                System.out.println("Runnable running");
            }
        };
        Thread thread1 = new Thread(myRunnable1);
        thread1.start();

        //给线程命名
        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable, "New Thread");
        thread2.start();
        System.out.println(thread2.getName());
    }
}
