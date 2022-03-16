package qrxedu.leedcode42;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int trap(int[] height) {
       int sum = 0;
       int len = height.length;
       for(int i = 1; i < len-1;i++){
           int maxLeft = 0,maxRight = 0;
           for(int j = i; j >= 0; j--){
                maxLeft = Math.max(maxLeft,height[j]);
           }
           for(int j = i; j < len; j++){
               maxRight = Math.max(maxRight,height[j]);
           }
           sum += Math.min(maxLeft,maxRight) - height[i];
       }
       return sum;
    }
}
