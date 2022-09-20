package qrxedu.lcseries.leedcode76;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m < n){
            return "";
        }
        int[] cnt = new int[60];
        int[] tmp = new int[60];
        for(int i = 0; i < n; i++){
            cnt[t.charAt(i)-'A']++;
        }
        int len = m;
        String res = "";
        int l = 0,r = 0;
        while(r < m){

            if(r < m){
                tmp[s.charAt(r)-'A']++;
                r++;
            }
            if(isV(cnt,tmp)) {
                while (isV(cnt, tmp) && l < r) {
                    if (len >= r - l) {
                        len = r - l;
                        res = s.substring(l, r);
                    }
                    tmp[s.charAt(l) - 'A']--;
                    l++;
                }
            }
        }

        return res;
    }
    private boolean isV(int[] cnt,int[] tmp){
        for(int i = 0; i < cnt.length;i++){
            if(tmp[i] < cnt[i]){
                return false;
            }
        }
        return true;
    }
    @Test
    public void show(){
        String s = "bdab";
        String t = "ab";
        System.out.println(minWindow(s,t));
    }
}
