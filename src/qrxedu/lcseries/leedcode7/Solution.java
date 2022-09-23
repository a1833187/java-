package qrxedu.lcseries.leedcode7;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int reverse(int x) {
        int i = x < 0 ? 1 : 0;
        String s =(String.valueOf(x));
        int l = i,r = s.length()-1;
        String ans = reverse(s,l,r);
        long num = Long.parseLong(ans);
        if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE){
            return 0;
        }else{
            return (int)num;
        }
    }
    public String reverse(String s,int l,int r){
        char[] arr = s.toCharArray();
        while(l < r){
            char ch = arr[l];
            arr[l] = arr[r];
            arr[r] = ch;
            l++;
            r--;
        }
        return new String(arr);
    }
}
