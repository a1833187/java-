package qrxedu.lcseries.leedcode84;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> d = new LinkedList<>();
        for(int i = 0; i < n; i++){
            while(!d.isEmpty() && heights[d.peek()] >= heights[i]){
                d.pop();
            }
            left[i] = d.isEmpty() ? -1 : d.peek();
            d.push(i);
        }
        d.clear();
        for(int i = n-1; i >= 0; i--){
            while(!d.isEmpty() && heights[d.peek()] >= heights[i]){
                d.pop();
            }
            right[i] = d.isEmpty() ? n : d.peek();
            d.push(i);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans,(right[i]-left[i]-1) * heights[i]);
        }
        return ans;
    }
    @Test
    public void show(){
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
