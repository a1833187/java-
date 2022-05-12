package qrxedu.leedcode944;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        if(m == 1){
            return 0;
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            char c1 = strs[0].charAt(i);
            for(int j = 1; j < m; j++){
                char c2 = strs[j].charAt(i);
                if(c1 > c2){
                    ans++;
                    break;
                }else{
                    c1 = c2;
                }
            }
        }
        return ans;


    }
}
