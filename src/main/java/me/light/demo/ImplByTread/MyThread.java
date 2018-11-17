package me.light.demo.ImplByTread;

public class MyThread extends Thread {

    public void run() {
        System.out.println("MyThread running");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        //匿名类实现
        Thread thread = new Thread() {
            public void run() {
                System.out.println("Thread Running");
            }
        };
        thread.start();
    }
}


