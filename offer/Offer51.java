package qrxedu.offer;

import java.util.Arrays;

/**
 * 求一个数组中的逆序对个数
 *
 * 在归并排序中的合并中进行计数:前面比后面的某个数大,说明前面的所有数和后面的该数均可以构成1个逆序对
 * @author qiu
 * @version 1.8.0
 */
public class Offer51 {
    int cnt = 0;
    public int reversePairs(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        int[] curNums = Arrays.copyOf(nums,len);
        reversePairs(curNums,0,len-1,temp);
        return cnt;
    }
    private void reversePairs(int[] nums,int left,int right,int[] temp){
        if(left < right){
            int mid = left + right >> 1;
            reversePairs(nums,left,mid,temp);
            reversePairs(nums,mid+1,right,temp);
            merge(nums,left,mid,right,temp);
        }
    }
    private void merge(int[] nums,int left,int mid,int right,int[] temp){
        for(int i = left; i <= right;i++){
            temp[i] = nums[i];
        }
        int l1 = left,l2 = mid+1;
        int l = left;
        while(l1 <= mid && l2 <= right){
            if(temp[l1] > temp[l2]){
                nums[l] = temp[l2];
                cnt+= mid-l1+1;
                l2++;
                l++;
            }else {
                nums[l] = temp[l1];
                l1++;
                l++;
            }
        }
        if(l1 > mid){
            for(;l2 <= right;l2++){
                nums[l++] = temp[l2];
            }
        }else if(l2 > right){
            for(;l1<=mid;l1++){
                nums[l++] = temp[l1];
            }
        }
    }
}
