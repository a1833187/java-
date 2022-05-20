package qrxedu.leedcode367;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1, r = (int)2e16;
        while(l < r){
            long mid = l + r >> 1;
            if(mid *mid >= num){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l * l == num;
    }
}
