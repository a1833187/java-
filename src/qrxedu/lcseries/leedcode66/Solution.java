package qrxedu.lcseries.leedcode66;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] ans = new int[n+1];
        int j = 0;
        for(int i = n; i >= 0; i--){
            int num = 0;
            if(i == n){
                num = digits[i-1]+1+j;
            }else if(i == 0){
                num = j;
            }else{
                num = digits[i-1]+j;
            }
            ans[i] = num%10;
            if(num/10>0){
                j = 1;
            }else{
                j = 0;
            }
        }
        if(ans[0] == 0){
            return Arrays.copyOfRange(ans,1,n+1);
        }else{
            return ans;
        }
    }
    @Test
    public void show(){
        int[] arr = {9,9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }
}
