package com.qrxedu.lcseries.leedcode424;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int characterReplacement(String s, int k) {
      int[] counts = new int[26];
      int l = 0;
      int r = 0;
      int max = 0;
      while(r < s.length()){
          counts[s.charAt(r)-'A']++;
          max = Math.max(max,counts[s.charAt(r)-'A']);
          if(r-l+1-max>k){
              counts[s.charAt(l)-'A']--;
              l++;
          }
          r++;
      }
      return r - l;
    }
    @Test
    public void show(){
        String s = "ABABBB";
        System.out.println(characterReplacement(s,2));
    }
}
