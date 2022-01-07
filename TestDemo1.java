package com.qrxedu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author qiu
 * @version 1.8.0
 */
public class TestDemo1 {
    public static void main(String[] args) {
        Integer[] arr = {1,4,6,2,3};
        Arrays.sort(arr,new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                int n1 = (Integer) o1;
                int n2 = (Integer) o2;
                return n2-n1;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
