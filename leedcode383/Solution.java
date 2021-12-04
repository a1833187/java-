package com.qrxedu.leedcode383;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()){
            return false;
        }
        int[] rcount = new int[26];
        int[] mcount = new int[26];
        for(int i = 0; i < ransomNote.length();i++){
            rcount[ransomNote.charAt(i)-'a']++;
        }
        for(int i = 0; i < magazine.length();i++){
            mcount[magazine.charAt(i)-'a']++;
        }
        for(int i = 0; i < rcount.length;i++){
            if(rcount[i] > mcount[i]){
                return false;
            }
        }
        return true;
    }
}
