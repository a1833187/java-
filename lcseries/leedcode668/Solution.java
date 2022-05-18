package qrxedu.leedcode668;

/**
 * 在乘法表中快速找到第k小的数字
 * 通过二分转化为:给定一个数,判断小于等于该数字的个数是否是k个.
 * 因为满足条件的值有且只有 1个,所以用常规的二分模板就可以.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l = 1,r = m * n;
        while(l < r){
            int mid = l + r >> 1;
            int count = 0;
            for(int i = 1; i <= m; i++){
                count += Math.min(mid/i,n);
            }
            if(count >= k){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}
