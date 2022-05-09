package qrxedu.leedcode137;

/**
 * 只出现一次的数字:只有1个数字出现1次,其他数字出现3次.
 * 分别统计答案的每一位:因为除了答案本身,剩下的每个数字的每一个二进制位上的值(1或0)相加取余均为0.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int total = 0;
            for(int num : nums){
                total += (num>>i)&1;
            }
            if(total % 3 != 0){
                ans |= 1<<i;
            }
        }
        return ans;
    }
}
