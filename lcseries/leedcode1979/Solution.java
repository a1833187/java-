package qrxedu.leedcode1979;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for(int num : nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        return gcd(min,max);
    }
    public int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a%b);
    }
}
