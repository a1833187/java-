package com.qrxedu.sort.radix;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author qiu
 * @version 1.8.0
 */
public class RadixSort {
    public void radixSort(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length;i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        int maxLen = (max + "").length();
        for(int i = 0; i < maxLen; i++){
            int[][] bucket = new int[10][arr.length];
            int[] bucketNum = new int[10];
            for(int j = 0; j < arr.length;j++){
                int w = arr[j]/(int)Math.pow(10,i)%10;
                bucket[w][bucketNum[w]] = arr[j];
                bucketNum[w] ++;
            }
            int c = 0;
            for(int k = 0; k < bucket.length;k++){
                for(int index = 0; index < bucketNum[k];index++){
                    arr[c++] = bucket[k][index];
                }
                bucketNum[k] = 0;
            }
        }
    }
    @Test
    public void show(){
        int[] arr = new int[9999999];
        for(int i = 0; i < arr.length;i++){
            arr[i] = (int)(Math.random()*9999999);
        }
        Date data1 = new Date();
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1= dateFormat1.format(data1);
        System.out.println("排序前:"+s1);
        radixSort(arr);
       /* System.out.println(Arrays.toString(arr));*/
        Date data2 = new Date();
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s2= dateFormat2.format(data2);
        System.out.println("排序后:"+s2);
    }
}
