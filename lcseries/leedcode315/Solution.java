package qrxedu.lcseries.leedcode315;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 计算右侧比当前元素小的元素个数
 * 利用归并排序每次进行统计,统计完后需要通过更新下标位置来模拟元素的位置不变
 * 关系到数组下标的题目优先考虑归并
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    int[] index;
    int[] tempIndex;
    int[] temp;
    int[] ans;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        index = new int[n];
        tempIndex = new int[n];
        temp = new int[n];
        ans = new int[n];
        for(int i = 0; i < n; i++){
            index[i] = i;
        }
        mergeSort(nums,0,n-1);
        List<Integer> l = new ArrayList<>();
        for(int num : ans){
            l.add(num);
        }
        return l;
    }
    private void mergeSort(int[] arr,int l,int r){
        if(l < r){
            int mid = l + r >> 1;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }
    private void merge(int[] arr,int l,int mid,int r){
        int i = l,j = mid + 1,p = l;
        while(i <= mid && j <= r){
            if(arr[i] <= arr[j]){
                temp[p] = arr[i];
                tempIndex[p] = index[i];
                ans[index[i]] += j - mid - 1;
                i++;
            }else{
                temp[p] = arr[j];
                tempIndex[p] = index[j];
                j++;
            }
            p++;
        }
        while(i <= mid){
            temp[p] = arr[i];
            tempIndex[p] = index[i];
            ans[index[i]] += j-mid-1;
            p++;
            i++;
        }
        while(j <= r){
            temp[p] = arr[j];
            tempIndex[p] = index[j];
            p++;
            j++;
        }
        for(int k = l; k <= r; k++){
            arr[k] = temp[k];
            index[k] = tempIndex[k];
        }
    }
    @Test
    public void show(){
        int[] nums = {5,2,6,1};
        System.out.println(countSmaller(nums));
    }
}
