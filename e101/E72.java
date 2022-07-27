package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E72 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int n = array.length;
        int ans = array[0];
        for(int i = 1; i < n; i++){
            if(array[i-1] >= 0){
                array[i] += array[i-1];
            }
            if(array[i] > ans){
                ans = array[i];
            }
        }
        return ans;
    }
}
