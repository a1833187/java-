package com.qrxedu.sort.select;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author qiu
 * @version 1.8.0
 */
public class SelectSort {
    public void select(int[] arr){
        for(int i = 0; i < arr.length-1;i++){
            int k = i;
            for(int j = i; j < arr.length;j++){
                if(arr[k] > arr[j]){
                    k = j;
                }
            }
            if(k!=i){
                int tmp = arr[i];
                arr[i] = arr[k];
                arr[k] = tmp;
            }
        }
    }
    @Test
    public void show(){
        int[] arr = new int[80000];
        for(int i = 0; i < arr.length;i++){
            arr[i] = (int)(Math.random()*Integer.MAX_VALUE);
        }
        Date data1 = new Date();
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1= dateFormat1.format(data1);
        System.out.println("排序前:"+s1);
        select(arr);
        Date data2 = new Date();
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s2= dateFormat2.format(data2);
        System.out.println("排序后:"+s2);
    }
}
