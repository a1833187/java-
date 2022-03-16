package qrxedu.leedcode72;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }
        int[][] minD = new int[m+1][n+1];
        for(int i = 0;i<=m;i++){
            minD[i][0] = i;
        }
        for(int i = 0; i<= n;i++){
            minD[0][i] = i;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                int k1 = Math.min(minD[i-1][j],minD[i][j-1])+1;
                int k2 = minD[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1);
                minD[i][j] = Math.min(k1,k2);
            }
        }
        return minD[m][n];
    }
}
