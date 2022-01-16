package com.qrxedu.lcseries.leedcode3;

import java.util.ArrayList;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author qiu
 * @version 1.8.0
 * 遍历所有起始位置，找到长度最长的非重复子串
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int res = 0;
        for(int i = 0; i < len; i++){
            char[] chars = s.substring(i).toCharArray();
            res = Math.max(res,findMax(chars));
        }
        return res;
    }

    /**
     * 找到字符串中某个起始位置固定的非重复子串
     * @param chars
     * @return
     */
    public int findMax(char[] chars){
        int len = chars.length;
        ArrayList<Character> tmp = new ArrayList<>();
        int i = 0;
        for(; i < len; i++){
            if(!tmp.contains(chars[i])){
                tmp.add(chars[i]);
            }else{
                break;
            }
        }
        return tmp.size();
    }
}
