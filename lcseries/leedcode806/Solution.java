package qrxedu.leedcode806;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int row = 1;
        int sum = widths[s.charAt(0)-'a'];
        for(int i = 1; i < s.length(); i++){
            int curLen = widths[s.charAt(i)-'a'];
            if(sum + curLen > 100){
                row++;
                sum = curLen;
            }else{
                sum += curLen;
            }
        }
        int[] ans = {row,sum};
        return ans;
    }
}
