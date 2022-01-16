package com.qrxedu.lcseries.leedcode5934;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author qiu
 * @version 1.8.0
 */
public class TestDemo {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new TreeMap<>();
        map.put(1,0);
        map.put(1,1);
        map.put(-1,2);
        System.out.println(map);
    }
}
