package qrxedu.lcseries.leedcode11;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0,r = height.length-1;
        while(l < r){
            if(height[l] <height[r]){
                res = Math.max(res,(r-l)*height[l]);
                l++;
            }else{
                res = Math.max(res,(r-l) * height[r]);
                r--;;
            }
        }
        return res;
    }
}
