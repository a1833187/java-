package qrxedu.lcseries.leedcode387;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            if(count[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
