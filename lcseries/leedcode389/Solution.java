package qrxedu.leedcode389;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];
        for(int i = 0; i< s.length();i++){
            countS[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            countT[t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26;i++){
            if(countT[i] - countS[i] == 1){
                return (char) (i + 97);

            }
        }
        return 'a';
    }
    @Test
    public void show(){
        int i = 97;
    }
}
