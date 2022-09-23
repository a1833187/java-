package qrxedu.lcseries.leedcode215;

import java.util.PriorityQueue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>(k);
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(i < k){
                p.offer(nums[i]);
            }else{
                if(p.peek() < nums[i]){
                    p.poll();
                    p.offer(nums[i]);
                }
            }
        }

        return p.peek();
    }
}
