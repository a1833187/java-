package qrxedu.leedcode172;

/**
 * 求n的阶乘中尾随0的个数
 * 求[1,n]中因子为10的个数，又因为10不是质因数，且10 = 2*5，所以求[1,n]中质因子为2或5的个数的
 * 较小值。其中质因数为5的个数一定少于质因数为2的个数。
 * 所以本题即为求[1,n]中质因数为5的个数。
 * 求[1,n]中质因数为5的个数：对于[1,n]而言，首先一定存在n/5个5，比如n=25对应的为5,10,15,20,25
 * 然后再看是否存在5^2，如25。这样求得的质因数为5的个数的时间复杂度更低。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int trailingZeros(int n){
        int ans = 0;
        while(n != 0){
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
