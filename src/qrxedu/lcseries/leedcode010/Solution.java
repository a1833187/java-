package qrxedu.lcseries.leedcode010;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean oneEditAway(String first, String second) {
        int m = first.length();
        int n = second.length();
        if(Math.abs(m-n) > 1){
            return false;
        }
        if(first.equals(second)){
            return true;
        }
        String f1,f2;
        if(m < n){
            f1 = first;
            f2 = second;
        }else{
            f1 = second;
            f2 = first;
        }
        m = f1.length();
        n = f2.length();
        //也可以合并,只是在某个字符不相等的时候,比较一下后续没有比较的字符的数量是否相等.
        if(m == n){
            int i1 = 0,i2 = 0;
            int cnt = 0;
            while(i1 < m && i2 < n){
                if(f1.charAt(i1) != f2.charAt(i2)){
                    cnt++;
                }
                i1++;
                i2++;
            }
            return cnt <= 1;
        }else{
            int i1 = 0,i2 = 0;
            int cnt = 0;
            while(i1 < m && i2 < n){
                if(f1.charAt(i1) != f2.charAt(i2)){
                    cnt++;
                    i2++;
                    while(i2 < n && f2.charAt(i2) != f1.charAt(i1)){
                        cnt++;
                        i2++;
                    }
                }
                i1++;
                i2++;

            }
            return cnt<=1;
        }
    }
    @Test
    public void show(){
        System.out.println(oneEditAway("pale","pal"));
    }
}
