package qrxedu.lcseries.leedcode125;

/**
 * 验证回文串
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) >='0' &&s.charAt(i) <= '9' || s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();
        for(int i = 0; i < s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

}
