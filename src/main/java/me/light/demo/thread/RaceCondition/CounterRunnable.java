package me.light.demo.thread.RaceCondition;

public class CounterRunnable implements Runnable {
    @Override
    public void run() {
        Counter counter = new Counter();
        counter.add(1);
        System.out.println(counter.getCount());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new CounterRunnable());
            thread.start();
        }
    }

}
