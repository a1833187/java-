package com.qrxedu.sort.bubble;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序
 * @author qiu
 * @version 1.8.0
 */
public class BubbleSort {
    public int[] bubble(int[] arr){
        for(int i = 0; i < arr.length-1;i++){
            //是否发生交换的标记
            int flag = 0;
            for(int j = 0; j < arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    //交换设定为1
                    flag = 1;
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            if(flag == 0){
                break;
            }
        }
        return arr;
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
        bubble(arr);
        Date data2 = new Date();
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s2= dateFormat2.format(data2);
        System.out.println("排序后:"+s2);
    }
}
