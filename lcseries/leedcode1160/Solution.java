package qrxedu.leedcode1160;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] count1 = new int[26];
        for(int i = 0; i < chars.length();i++){
            count1[chars.charAt(i) - 'a']++;
        }
        int res = 0;
        for(int i = 0; i < words.length;i++){
            int[] count2 = new int[26];
            for(int j = 0;j < words[i].length();j++){
                count2[words[i].charAt(j) - 'a']++;
            }
            int k = 0;
            for(; k < 26; k++){
                if(count2[k] > count1[k]){
                    break;
                }
            }
            if(k == 26){
                res+=words[i].length();
            }
        }
        return res;
    }
}
