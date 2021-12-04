package com.qrxedu.sort.quick;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @author qiu
 * @version 1.8.0
 */
public class QuickSort {
    public void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int mid = arr[new Random().nextInt(right-left)+left];
        int tmp = 0;
        while (l < r) {
            //左指针指向的元素小于中间元素时指针往后探索
            while (arr[l] < mid) {
                l++;
            }
            //右指针指向的元素大于中间元素时指针往前探索
            while (arr[r] > mid) {
                r--;
            }
            if (l >= r) {
                break;
            }
            //交换中间元素两侧满足条件的两个元素
            tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            //!!当中间元素两侧满足条件的元素不相等时,较少一侧的指针会优先指到中间元素
            //在这种情况下，中间元素会和另一侧的条件元素进行交换,这时需要交换前指向中间的元素指针前(后)移
            //避免出现无限无意义交换
            if (arr[l] == mid) {
                r--;
            }
            if (arr[r] == mid) {
                l++;
            }
        }
        //!!循环结束后，左右指针可能均指向中间元素，
        // 在进行左右递归快排前,要把左右递归的边界条件进行相应移动
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            //左递归快排
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
    public void quickSort1(int[] arr,int left,int right){
        if(left < right){
            int i = partition(arr,left,right);
            quickSort1(arr,left,i-1);
            quickSort1(arr,i+1,right);
        }
    }
    public int partition(int[] arr,int left,int right){
        int x = arr[left];
        int i = left;
        for(int j = left + 1; j <= right;j++){
            if(arr[j] < x){
                i = i + 1;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[left];
        arr[left] = arr[i];
        arr[i] = tmp;
        return i;
    }
//2 5 3 6 1
    @Test
    public void show() {
        int[] arr = new int[800000];
        for(int i = 0; i < arr.length;i++){
            arr[i] =  arr.length-i;
        }
        int[] arr1 = {2,5,3,6,1};
        Date data1 = new Date();
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1= dateFormat1.format(data1);
        System.out.println("排序前:"+s1);
        quickSort(arr,0,arr.length-1);
        Date data2 = new Date();
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s2= dateFormat2.format(data2);
        System.out.println("排序后:"+s2);
    }
}
