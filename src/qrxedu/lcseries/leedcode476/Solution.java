package qrxedu.lcseries.leedcode476;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findComplement(int num) {
        int ans = 0;
        int k = 0;
        int tmp = num;
        while(tmp != 0){
            tmp >>= 1;
            k++;
        }
        for(int i = 0; i < k; i++){
            int cur = ((num) >> i) & 1;
            if(cur == 0){
                ans += (int)Math.pow(2,i);
            }
        }
        return ans;
    }
}
