package qrxedu.leedcode1438;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    int n;
    int lim;
    public int longestSubarray(int[] nums, int limit) {
        n = nums.length;
        lim = limit;
        int l = 0,r = n;
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(check(nums,mid)){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
    public boolean check(int[] arr,int mid){
        int l = 0,r = 0;
        Deque<Integer> minD = new LinkedList<>();
        Deque<Integer> maxD = new LinkedList<>();
        for(;r-l+1<=mid && r < n;r++){
            while(!minD.isEmpty() && arr[minD.peekLast()] > arr[r]){
                minD.pollLast();
            }
            minD.offerLast(r);
            while(!maxD.isEmpty() && arr[maxD.peekLast()] < arr[r]){
                maxD.pollLast();
            }
            maxD.offerLast(r);
            if(r - l + 1 == mid){
                if(arr[maxD.peekFirst()] - arr[minD.peekFirst()] <= lim){
                    return true;
                }else{
                    if(minD.peekFirst() == l){
                        minD.pollFirst();
                    }
                    if(maxD.peekFirst() == l){
                        maxD.pollFirst();
                    }
                    l++;
                }
            }
        }
        return false;
    }
    @Test
    public void show(){
        int[] arr = {8,2,4,7};
        System.out.println(longestSubarray(arr,4));
    }
}
