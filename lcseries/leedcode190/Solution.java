package qrxedu.leedcode190;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int w = (n >> i)&1;
            ans |= w <<(31-i);
        }
        return ans;
    }
}
