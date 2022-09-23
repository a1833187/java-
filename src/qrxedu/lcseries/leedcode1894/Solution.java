package qrxedu.lcseries.leedcode1894;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int chalkReplacer(int[] chalk, int k_) {
        long sum = 0;
        long k = k_;
        for(int num : chalk){
            sum += num;
        }
        if(k % sum == 0){
            return 0;
        }
        k = k % sum;
        int n = chalk.length;
        for(int i = 0; i < n; i++){
            if(k >= chalk[i]){
                k-=chalk[i];
            }else{
                return i;
            }
        }
        return 0;
    }
}
