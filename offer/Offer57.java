package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer57 {
    public int[] singleNumbers(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for(int num : nums){
            ans ^= num;
        }
        int k = 0;
        while(((ans >> k) & 1) == 0){
            k++;
        }
        int ans1 = 0,ans2 = 0;
        for(int num : nums){
            if(((num >> k) & 1) == 0){
                ans1 ^= num;
            }else{
                ans2 ^= num;
            }
        }
        return new int[]{ans1,ans2};
    }
}
