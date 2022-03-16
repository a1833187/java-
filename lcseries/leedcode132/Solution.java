package qrxedu.leedcode132;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int minCut(String s) {
        int[] minNums = new int[s.length()+1];
        Arrays.fill(minNums,s.length()-1);
        minNums[0] = -1;
        int m = s.length();
        boolean[][] isPal = new boolean[m][m];
        for(int i = 0; i < m;i++){
            isPal[i][i] = true;
        }
        for(int i = m-1;i>=0;i--){
            for(int j = m-1; j > i;j--){
                if(j == i+1){
                    isPal[i][j] = s.charAt(i)==s.charAt(j);
                }else if(s.charAt(i) == s.charAt(j)){
                    isPal[i][j] = isPal[i+1][j-1];
                }
            }
        }
        for(int i = 1; i <= m; i++){
            for(int j = 0; j < i; j++){
                if(isPal[j][i-1]){
                    minNums[i] = Math.min(minNums[i],minNums[j] + 1);
                }
            }
        }
        return minNums[m];
    }
}
