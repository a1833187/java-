package qrxedu.offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer63 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int n = nums.length;
        if(n == 0){
            return nums;
        }
        int[] ans = new int[n - k + 1];
        int index = 0;
        for(int i = 0; i < n; i++){
            while(!q.isEmpty() && nums[i] >= nums[q.peekLast()]){
                q.pollLast();
            }
            q.offerLast(i);
            if(i >= k - 1){
                ans[index++] = nums[q.peekFirst()];
                if(q.peekFirst() == i - k + 1){
                    q.pollFirst();
                }
            }
        }
        return ans;
    }
    @Test
    public void show(){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums,3)));
    }
}
