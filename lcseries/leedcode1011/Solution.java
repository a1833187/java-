package qrxedu.leedcode1011;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Solution {
    int[] weights;
    int days;
    int n;
    public int shipWithinDays(int[] _weights, int _days) {
        weights = _weights;
        days = _days;
        int r = 0;
        n = weights.length;
        for(int w : weights){
            r += w;
        }
        int l = 1;
        while(l < r){
            int mid = l + r >> 1;
            if(check(mid)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    public boolean check(int mid){
        int curD = days;
        int curM = mid;
        for(int i = 0; i < n; i++){
            if(weights[i] <= curM){
                curM -= weights[i];
            }else{
                curM = mid;
                curD--;
                i--;
            }
            if(curD <= 0){
                return false;
            }
        }
        return true;
    }
    @Test
    public void show(){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(arr,5));
    }
}
