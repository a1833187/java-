package qrxedu.lcseries.leedcode541;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String reverseStr(String s, int k) {
        char[] ss = s.toCharArray();
        for(int i = 0; i < ss.length;i+=2*k){
            int len = Math.min(ss.length,k+i);
            for(int j = i,l = len - 1;j< l;j++,l--){
                char temp = ss[j];
                ss[j] = ss[l];
                ss[l] = temp;
            }
        }
        return new String(ss);
    }
}
