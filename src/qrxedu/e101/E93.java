package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E93 {
    public int maxArea (int[] height) {
        // write code here
        int ans = 0;
        int n = height.length;
        int l = 0,r = n-1;
        while(l < r){
            ans = Math.max(ans,Math.min(height[r],height[l]) * (r-l));
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }

        }
        return ans;
    }
}
