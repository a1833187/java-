package qrxedu.leedcode1221;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int balancedStringSplit(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int count = 0;
        int balance = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'R'){
                balance--;
            }
            if(s.charAt(i) == 'L'){
                balance++;
            }
            if(balance == 0){
                count++;
            }
        }
        return count;
    }
}
