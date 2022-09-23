package qrxedu.lcseries.leedcode171;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int n = columnTitle.length();
        for(int i = 0; i < n; i++){
            int num = columnTitle.charAt(i)-'A'+1;
            ans = ans * 26 +num;
        }
        return ans;
    }
}
