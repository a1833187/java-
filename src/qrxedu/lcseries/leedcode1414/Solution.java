package qrxedu.lcseries.leedcode1414;

/**
 * 贪心:和为K的最少斐波那契数字的数目.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findMinFibonacciNumbers(int k) {
        int a = 1, b = 1;
        int c;
        while(b <= k){
            c = a + b;
            a = b;
            b = c;
        }
        int ans = 0;
        while(b >= 1){
            if(b <= k){
                k-=b;
                ans++;
            }
            c = b - a;
            b = a;
            a = c;
        }
        return ans;
    }
}
