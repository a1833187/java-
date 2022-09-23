package qrxedu.lcseries.leedcode744;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if(target >= letters[n-1]){
            return letters[0];
        }
        int l = 0,r = n-1;
        while(l < r){
            int mid = l + r >> 1;
            if(letters[mid] >= target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return letters[l];
    }
    @Test
    public void show(){
        System.out.println(0+0>>1);
    }
}
