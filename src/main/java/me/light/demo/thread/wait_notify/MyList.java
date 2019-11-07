package me.light.demo.thread.wait_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * @author light.hao
 * @date 2019/11/7 4:53 PM
 */
public class MyList {

    private volatile List<String> list = new ArrayList<>();

    public void add() {
        list.add("aaa");
    }

    public int size() {
        return list.size();
    }
}

// 线程A
class ThreadA extends Thread {
    private MyList list;

    public ThreadA(MyList list, String name) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                list.add();
                System.out.println("添加了" + (i + 1) + "个元素");
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//线程B
class ThreadB extends Thread {
    private MyList list;

    public ThreadB(MyList list, String name) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (list.size() == 2) {
                    System.out.println("==2了，线程b要退出了！");
                    throw new InterruptedException();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



