package qrxedu.lcseries.leedcode824;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public char[] dict = {'a','e','i','o','u','A','E','I','O','U'};
    public String toGoatLatin(String sentence) {
        String[] strs = sentence.split(" ");
        int k = 1;
        for(int i = 0; i < strs.length; i++){
            StringBuilder s = new StringBuilder(strs[i]);
            if(isY(s.charAt(0))){
                s.append("ma");
            }else{
                s.append(s.charAt(0));
                s.append("ma");
                s.deleteCharAt(0);
            }
            for(int j = 0; j < k; j++){
                s.append('a');
            }
            k++;
            strs[i] = new String(s);
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < strs.length; i++){
            if(i != strs.length-1){
                ans.append(strs[i]);
                ans.append(' ');
            }else{
                ans.append(strs[i]);
            }
        }
        return new String(ans);
    }
    public boolean isY(char ch){
        for(int i = 0; i < dict.length; i++){
            if(dict[i] == ch){
                return true;
            }
        }
        return false;
    }
}
