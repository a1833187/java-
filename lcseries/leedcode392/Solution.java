package qrxedu.leedcode392;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()){
            return false;
        }
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            boolean flag = false;
            while(j < t.length()){
                if(t.charAt(j) == s.charAt(i)){
                    flag = true;
                    break;
                }else{
                    j++;
                }
            }
            if(j == t.length()){
                flag = false;
            }
            if(!flag){
                return false;
            }
            j++;
        }
        return true;
    }
}
