package qrxedu.offer;

import org.junit.jupiter.api.Test;

import java.util.logging.Level;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer61 {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        String[] strs = s.split(" ");
        String ans = "";
        int n = strs.length;
        for(int i = n-1; i >= 0; i--){
            if("".equals(strs[i])){
                continue;
            }
            ans += strs[i] + " ";
        }
        if(ans.length() == 0){
            return ans;
        }
        return ans.substring(0,ans.length()-1);
    }
    @Test
    public void show(){
        System.out.println(reverseWords(" hello world! "));
    }
    public char[] reverse(char[] arr,int l,int r){
        while(l < r){
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
        return arr;
    }
}
