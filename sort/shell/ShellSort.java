package com.qrxedu.sort.shell;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 希尔排序
 * @author qiu
 * @version 1.8.0
 */
public class ShellSort {
    public void shellSort(int[] arr){
        for(int tap = arr.length/2;tap!=0;tap/=2){
            for(int i = tap; i < arr.length;i++){
                int j = i;
                int val = arr[j];
                while(j-tap>=0&&arr[j] < arr[j - tap]){
                    arr[j] = arr[j - tap];
                    j -= tap;
                }
                arr[j] = val;
            }
        }
    }

    @Test
    public void show(){
        int[] arr = new int[99999];
        for(int i = 0; i < arr.length;i++){
            arr[i] = (int)(Math.random()*Integer.MAX_VALUE);
        }
        Date data1 = new Date();
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1= dateFormat1.format(data1);
        System.out.println("排序前:"+s1);
        shellSort(arr);
        Date data2 = new Date();
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s2= dateFormat2.format(data2);
        System.out.println("排序后:"+s2);
    }
}
