package com.qrxedu.lcseries.leedcode58;

import org.junit.jupiter.api.Test;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        String s1 = s.trim();
        int len1 = s1.length();
        System.out.println(len1);
        for(int i = len1-1;i>=0;i--){
            if(s1.charAt(i) == ' '){
                break;
            }
            len++;
        }
        return len;
    }
    @Test
    public void show(){
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
