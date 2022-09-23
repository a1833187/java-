package qrxedu.lcseries.leedcode696;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    // 统计连续出现的相同字符的个数，满足题意的子串等于相邻的相同字符个数的最小值。
    public int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        int cur = 0;
        while(cur < s.length()){
            char ch = s.charAt(cur);
            int count = 1;
            cur++;
            while(cur < s.length() && ch == s.charAt(cur)){
                count++;
                cur++;
            }
            list.add(count);
        }
        int res = 0;
        for(int i = 1; i < list.size();i++){
            res += Math.min(list.get(i-1),list.get(i));
        }
        return res;
    }
    @Test
    public void show(){
        String s = "00110011";
        System.out.println(countBinarySubstrings(s));
    }
    /*
     int count0 = 0;
        int count1 = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            if (s.charAt(j) == '0') {
                count0++;
                while (j < s.length() && s.charAt(j) == '0' && j + 1 < s.length() && s.charAt(j + 1) == '0') {
                    count0++;
                    j++;
                }
                j++;
                if(j < s.length()) {
                    count1++;
                }
                while (j < s.length() && s.charAt(j) == '1' && j + 1 < s.length() && s.charAt(j + 1) == '1') {
                    count1++;
                    j++;
                }
                if(count1 >= count0){
                    count++;
                }
            } else {
                count1++;
                while (j < s.length() && s.charAt(j) == '1' && j + 1 < s.length() && s.charAt(j + 1) == '1') {
                    count1++;
                    j++;
                }
                j++;
                if(j < s.length()) {
                    count0++;
                }
                while (j < s.length() && s.charAt(j) == '0' && j + 1 < s.length() && s.charAt(j + 1) == '0') {
                    count0++;
                    j++;
                }
                if(count0 >= count1){
                    count++;
                }
            }
            count0 = 0;
            count1 = 0;
        }
        return count;
     */
}
