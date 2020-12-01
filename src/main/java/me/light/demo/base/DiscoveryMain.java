package me.light.demo.base;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author light.hao
 * @date 2020/9/28 3:06 下午
 */
public class DiscoveryMain {
    public static void main(String[] args) {
        List<Pair<String, Double>> list = new ArrayList<Pair<String, Double>>();
        list.add(new ImmutablePair<String, Double>("1.0", 10D));
        list.add(new ImmutablePair<String, Double>("2.0", 50D));
        list.add(new ImmutablePair<String, Double>("3.0", 40D));

        int v1Count = 0;
        int v2Count = 0;
        int v3Count = 0;
        int totalCount = 1000;
        for (int i = 0; i < totalCount; i++) {
            MapWeightRandom<String, Double> weightRandom = new MapWeightRandom<String, Double>(list);
            String server = weightRandom.random();
            if (server.startsWith("1.0")) {
                v1Count++;
            }
            if (server.startsWith("2.0")) {
                v2Count++;
            }
            if (server.startsWith("3.0")) {
                v3Count++;
            }
        }

        System.out.println("------------------------------");
        System.out.println(totalCount + "次循环，散列方式随机权重准确度和性能：");
        DecimalFormat format = new DecimalFormat("0.0000");
        System.out.println("1.0版本服务随机权重=" + format.format((double) v1Count * 100 / totalCount) + "%");
        System.out.println("2.0版本服务随机权重=" + format.format((double) v2Count * 100 / totalCount) + "%");
        System.out.println("3.0版本服务随机权重=" + format.format((double) v3Count * 100 / totalCount) + "%");
    }
}
