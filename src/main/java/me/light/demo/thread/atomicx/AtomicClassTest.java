package me.light.demo.thread.atomicx;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author light.hao
 * @date 2020/8/24 2:54 下午
 */
public class AtomicClassTest {
    private final AtomicInteger nextIndex = new AtomicInteger();

    public static void main(String[] args) {

    }

    class test{
        public void test(){
            System.out.println(nextIndex.get());
        }
    }
}
