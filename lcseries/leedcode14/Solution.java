package qrxedu.leedcode14;

/**
 * 最长公共前缀
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        int minlen = strs[0].length();
        for(int i = 0; i < strs.length; i++){
            if(minlen > strs[i].length()){
                minlen = strs[i].length();
            }
        }
        for(int j = 0; j < minlen; j++) {
            int i = 0;
            for (; i < strs.length - 1; i++) {
                if(strs[i].charAt(j) != strs[i+1].charAt(j)){
                    break;
                }
            }
            if(i == strs.length - 1){
                res += strs[0].charAt(j);
            }else{
                return res;
            }
        }
        return res;
    }
}
