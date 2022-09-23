package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer53 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n;i++){
            ans ^= nums[i];
            ans ^= i;
        }
        ans ^= n;
        return ans;
    }
}
