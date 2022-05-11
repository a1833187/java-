package qrxedu.leedcode477;

/**
 * 汉明距离总和:统计数组中任意两者数字的汉明距离的和
 * 乘法原理:统计所有数字上第i位上是0还是1,假设第i位上为0的个数为c个,那么为1的个数为(n-c)个
 * 就这一位上的汉明距离的和为c*(n-c)
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i <= 31; i++) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }
}
