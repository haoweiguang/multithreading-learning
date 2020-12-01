package me.light.demo.test;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author light.hao
 * @date 2020/7/10 10:40 AM
 */
public class TestApp {
    public static void main(String[] args) {
        String idStrList = "1,2,3,, ,4";
        List<String> idList = stringToList(idStrList);
        idList.forEach(p -> {
            System.out.println(p);
        });

    }

    public static List<String> stringToList(String stringList) {
        return Arrays.asList(StringUtils.split(stringList, ","));
    }
}
