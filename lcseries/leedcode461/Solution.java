package qrxedu.leedcode461;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int cnt = 0;
        for(int i = 31; i >= 0; i--){
            int tmpX = x >> i;
            int tmpY = y >> i;
            if((tmpX&1) == (tmpY&1)){
                cnt++;
            }
        }
        return cnt;
    }
}
