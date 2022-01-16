package com.qrxedu.lcseries.leedcodde5942;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] findEvenNumbers(int[] digits) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        for(int i = 0; i <digits.length;i++){
            list1.add(digits[i]);
        }
        int l = 0;
        list1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        while(l < list1.size()-3){
            int count = 0;
            if(list1.get(l).equals(list1.get(l+1))&&list1.get(l+1).equals(list1.get(l+2))
                    &&list1.get(l+2).equals(list1.get(l+3))&&list1.get(l)!=0){
                list1.remove(l);
            }else if(list1.get(l).equals(list1.get(l+1))&&list1.get(l+1).equals(list1.get(l+2))
                    &&list1.get(l)==0){
                list1.remove(l);
            }else{
                l++;
            }
        }
        int len = digits.length;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list1.size(); j++) {
                if (j != i) {
                    for (int k = 0; k < list1.size(); k++) {
                        if (k != j && k != i&&list1.get(i) != 0 && list1.get(k)%2==0) {
                            int n = 100 * list1.get(i) + 10 * list1.get(j) + list1.get(k);
                            list.add(n);
                        }
                    }
                }
            }
        }
        int i = 0;
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        while(i < list.size()-1){
            if(list.get(i + 1).equals(list.get(i))){
                list.remove(i);
            }else{
                i++;
            }
        }
        int[] out = new int[list.size()];
        for(int j = 0; j < out.length;j++){
            out[j] = list.get(j);
        }
        Arrays.sort(out);
        return out;
    }
    @Test
    public void show(){
        int[] digits = {0,1,2,8,2,7,5,0,8,9,5,9,8,9,0,5,0,5,8,0,5,1,8,6,7,2,2,0,4,8,2,9,7,3,8,6,3,8,5,2,4,6,2,0,7,4,2,3,3,8,1
                ,7,3,5,3,8,1,8,4,0,9,7,1,7,1,8,9,5,0,1,5,0,2,2,2,7,6,0,2,7,2,3,9,3,4,2,5,5};
        System.out.println(Arrays.toString(findEvenNumbers(digits)));
    }
}
