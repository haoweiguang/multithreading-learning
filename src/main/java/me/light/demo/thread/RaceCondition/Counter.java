package me.light.demo.thread.RaceCondition;

public class Counter {
    private long count = 0;

    public void add(long value) {
        this.count = this.count + value;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
