package com.qrxedu.sort.insertion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class InsertSort {
    public void insert(int[] arr){
       for(int i = 1 ; i< arr.length;i++){
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while(insertIndex>=0&&insertVal<arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertVal;
       }
    }
    public void midInsert(int[] arr){
        for(int i = 1; i<arr.length;i++){
            int insertVal = arr[i];
            int low = 0;
            int high = i -1;
            while(low<=high){
                int mid = (low + high)/2;
                if(insertVal<arr[mid]){
                    high = mid -1;
                }else{
                    low = mid + 1;
                }
            }
            for(int j = i; j>low;j--){
                arr[j] = arr[j-1];
            }
            arr[low] = insertVal;
        }
    }
    @Test
    public void show(){
        int[] arr = {5,4,3,2,1};
        int[] arr1 = {-1,-2,3,123,12,3,333};
        insert(arr);
        midInsert(arr1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }
}
