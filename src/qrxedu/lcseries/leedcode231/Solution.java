package qrxedu.lcseries.leedcode231;

/**
 * 判断1个数是否为2的幂
 * 1.n一定大于0,n如果是2的幂,则其二进制表示只有最高位上为1
 * 因此可以转换成2种方式
 *  1.SWAR统计n的二进制表示中1的个数
 *  2.利用n的性质,n-1的二进制表示上除了最高位都是1,令n&n-1 == 0 ? true : false;
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n-1)) == 0);
    }
    public boolean isPowerOfTwo1(int n) {
        if(n <= 0){
            return false;
        }
        n = (n & 0x55555555) + ((n >> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
        n = (n & 0x0F0F0F0F) + ((n >> 4) & 0x0F0F0F0F);
        n = (n & 0x00FF00FF) + ((n >> 8) & 0x00FF00FF);
        n = (n & 0x0000FFFF) + ((n >> 16) & 0x0000FFFF);
        return n == 1;
    }
}
