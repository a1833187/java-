package qrxedu.algorithm.day9.three;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String leftReverseOfStr(String str,int k){
        if(str == null || str.length() == 0){
            return str;
        }
        int len = str.length();
        int k1 = k % len;
        String str1 = str.substring(0,k1);
        String str2 = str.substring(k1,str.length());
        return str2 + str1;
    }
}
