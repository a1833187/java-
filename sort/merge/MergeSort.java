package com.qrxedu.sort.merge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class MergeSort {
    @Test
    public void show(){
        int[] arr = {-1,2,4,3,12,32321,33};
        int[] tmp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,tmp);
        System.out.println(Arrays.toString(arr));
    }
    public void mergeSort(int[] arr,int left,int right,int[] tmp){
        if(left < right){
            int mid = (left+right) / 2;
            mergeSort(arr,left,mid,tmp);
            mergeSort(arr,mid+1,right,tmp);
            merge(arr,left,mid,right,tmp);
        }
    }

    public void merge(int[] arr,int left,int mid,int right,int[] tmp){
        int i = left;
        int j = mid +1;
        int k = 0;
        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                tmp[k++] = arr[i++];
            }else{
                tmp[k++] = arr[j++];
            }
        }
        while(i<=mid){
            tmp[k++] = arr[i++];
        }
        while(j <= right){
            tmp[k++] = arr[j++];
        }
        int tLeft = left;
        k = 0;
        for(;tLeft <= right;tLeft++){
            arr[tLeft] = tmp[k++];
        }
    }
}
