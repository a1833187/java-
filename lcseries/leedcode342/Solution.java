package qrxedu.leedcode342;

/**
 * 4的幂:首先需要保证只能有二进制表示中只能有1个1,也就是前提是必须是2的幂
 * 然后1的位置必须在奇数位置上,所以和(0101010101..01),也就是0xaaaaaaaa与运算.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0){
            return false;
        }
        return ((n & (n-1)) == 0) && ((n & 0xaaaaaaaa) == 0);
    }
}
