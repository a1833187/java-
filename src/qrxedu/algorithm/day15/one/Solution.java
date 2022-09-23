package qrxedu.algorithm.day15.one;

/**
 * 选择排序：体现的是贪心思想。不考虑全局，只考虑在当前情况下(未排序的数组)的最小值，也就是得到局部最优解，
 * 最后根据所有的局部最优解来得到全局最优解
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public void selectSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            int k = i;
            for(int j = i; j < n; j++){
                if(arr[k] > arr[j]){
                    k = j;
                }
            }
            if(k != i){
                int tmp = arr[i];
                arr[i] = arr[k];
                arr[k] = tmp;
            }
        }
    }
}
