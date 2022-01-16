package com.qrxedu.lcseries.leedcode859;

/**
 * 给你两个字符串s和goal只要我们可以通过交换s中的两个字母得到与goal相等的结果，就返回true；否则返回 false 。
 *
 * 交换字母的定义是：取两个下标i和j（下标从 0 开始)且满足i!=j接着交换s[i]和s[j]处的字符。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean buddyStrings(String s, String goal) {
        int len = s.length();
        if(s.length() != goal.length()){
            return false;
        }
        String tmp = "";
        int[] count = new int[26];
        if(s.equals(goal)) {
            for(int i = 0; i < len; i++){
                count[s.charAt(i)-'a']++;
                if(count[s.charAt(i)-'a']>1){
                    return true;
                }
            }
        }
        for(int i = 0; i < len-1; i++){
            for(int j = i; j < len; j++){
                tmp = swap(s,i,j);
                if(tmp.equals(goal)){
                    return true;
                }
            }
        }
        return false;
    }
    public String swap(String s,int i, int j){
        char[] o = s.toCharArray();
        char temp = o[i];
        o[i] = o[j];
        o[j] = temp;
        return new String(o);
    }


    /*
        长度不相同为false
     if (s.length() != goal.length()) {
            return false;
        }
        如果两个字符串完全相同：1.没有重复元素就为false 2.有至少一个重复元素返回true
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
                if (count[s.charAt(i) - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        } else {
            不完全相同则至少有1个对应位置的字符不一样
            int first = -1, second = -1;
            for (int i = 0; i < goal.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }
            如果只有1个位置的字符不一样为false，有3个及以上位置的字符不一样也为false
            有2个字符的位置不一样如果无法对应交换相同也为false
            return (second != -1 && s.charAt(first) == goal.charAt(second) &&
                    s.charAt(second) == goal.charAt(first));
        }
     */
}
