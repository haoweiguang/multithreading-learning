package me.light.demo.collectiondemo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * test
 *
 * @author light.hao
 * @date 2019/2/25 上午10:46
 */
public class Test {

    public static void main(String[] args) {

        Queue<String> queue;

        ArrayDeque arrayDeque;

        LinkedList linkedList;

        AbstractQueue abstractQueue;

        ArrayList arrayList;

        ConcurrentHashMap map;

        HashMap hashMap;

        AtomicInteger atomicInteger;

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        List<Integer> list1=new LinkedList<>();
        Iterator iterator1=list1.iterator();
    }

}
