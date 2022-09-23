package qrxedu.lcseries.leedcode1823;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findTheWinner(int n, int k) {
        int[] arr = new int[n];
        int cnt = n;
        int i = 0;
        while(cnt != 1){
            int curK = k;
            while(curK != 0 && i < n){
                if(arr[i] == 0){
                    curK--;
                }
                if(i < n-1) {
                    i++;
                }else{
                    i = 0;
                }
            }
            if(i == 0){
                arr[n-1] = -1;
            }else{
                arr[i-1] = -1;
            }
            cnt--;
        }
        for(i = 0; i < n; i++){
            if(arr[i] == 0){
                return i+1;
            }
        }
        return -1;
    }
}
