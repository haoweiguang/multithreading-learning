package me.light.demo.base;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 *
 * @author Haojun Ren
 * @version 1.0
 */

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapWeightRandom<K, V extends Number> {
    private TreeMap<Double, K> weightMap = new TreeMap<Double, K>();

    public MapWeightRandom(List<Pair<K, V>> pairlist) {
        for (Pair<K, V> pair : pairlist) {
            double value = pair.getValue().doubleValue();
            if (value <= 0) {
                continue;
            }

            double lastWeight = weightMap.size() == 0 ? 0 : weightMap.lastKey().doubleValue();
            weightMap.put(value + lastWeight, pair.getKey());
        }
    }

    public K random() {
        if (MapUtils.isEmpty(weightMap)) {
        }

        double randomWeight = weightMap.lastKey() * Math.random();
        SortedMap<Double, K> tailMap = weightMap.tailMap(randomWeight, false);

        return weightMap.get(tailMap.firstKey());
    }
}
