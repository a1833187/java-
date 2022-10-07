package qrxedu.lcseries.leedcode647;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        for(int i = 0; i < n; i++){
            f[i][i] = true;
            if(i+1<n){
                f[i][i+1] = s.charAt(i) == s.charAt(i+1);
            }
        }
        for(int len = 3; len <= n; len++){
            for(int l = 0; l <= n - len; l++){
                int r = l + len - 1;
                if(s.charAt(l) == s.charAt(r)){
                    f[l][r] = f[l+1][r-1] || f[l][r];
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(f[i][j]){
                    ans++;
                }
            }
        }
        return ans;
    }
}
