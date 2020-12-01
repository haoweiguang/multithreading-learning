package me.light.demo.base;

import org.checkerframework.checker.units.qual.K;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author light.hao
 * @date 2020/1/19 2:27 PM
 */
public class MainTest {

    public static void main(String[] args) {
        TreeMap<Double, String> weightMap = new TreeMap<Double, String>();
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            weightMap.put(Double.valueOf("90"), "s1");
            weightMap.put(Double.valueOf("180"), "s2");
            weightMap.put(Double.valueOf("100"), "s-gray");
//        weightMap.put(Double.valueOf("4"), "s4");
//        weightMap.put(Double.valueOf("5"), "s5");

//            System.out.println("size:" + weightMap.size() + ",key:" + weightMap.lastKey());

            double randomWeight = weightMap.lastKey() * Math.random();
            SortedMap<Double, String> tailMap = weightMap.tailMap(randomWeight, false);

            String serviceName = weightMap.get(tailMap.firstKey());
            Integer count = result.get(serviceName);
            result.put(serviceName, count == null ? 0 : count + 1);
        }
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }
    }
}
