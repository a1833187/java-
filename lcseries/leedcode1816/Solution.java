package com.qrxedu.lcseries.leedcode1816;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String truncateSentence(String s, int k) {
        s+=' ';
        int count = 0;
        int i;
        for(i = 0; i < s.length();i++){
            if(s.charAt(i) == ' '){
                count++;
            }
            if(count == k){
                break;
            }
        }
        if(count != k){
            return "";
        }else {
            return s.substring(0, i);
        }
    }
    @Test
    public void show(){
        System.out.println(Arrays.toString(prefix(new int[]{1, 2, 3, 4, 5})));
    }
    public int[] prefix(int[] arr){
        int[] prefixArr = new int[arr.length];
        prefixArr[0] = arr[0];
        for(int i = 1; i < arr.length;i++){
            prefixArr[i] = prefixArr[i-1] + arr[i];
        }
        return prefixArr;
    }
}
