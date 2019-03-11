package me.light.demo.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的例子
 *
 * @author light.hao
 * @date 2019/3/8 上午11:02
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

    }
}

class MathCounter implements Callable<Integer> {
    private int count;


    @Override
    public Integer call() throws Exception {
        count = 0;
        return count;
    }
}
