package qrxedu.leedcode474;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[] zeroNums = new int[l+1];
        int[] oneNums = new int[l+1];
        for(int i = 1; i <= l; i++){
            String str = strs[i-1];
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '0'){
                    zeroNums[i]++;
                }else{
                    oneNums[i]++;
                }
            }
        }
        int[][][] f = new int[l+1][m+1][n+1];

        for(int i = 1; i <= l; i++){
            //这里要从0开始,因为存在某个strs[i-1]只有0或只有1的情况
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <= n; k++){
                    int zero = zeroNums[i];
                    int one = oneNums[i];
                    if(zero <= j && one <= k){
                        f[i][j][k] = Math.max(f[i-1][j][k],f[i-1][j-zero][k-one]+1);
                    }else{
                        f[i][j][k] = f[i-1][j][k];
                    }
                }
            }
        }
        return f[l][m][n];
    }
    @Test
    public void show(){
        String[] strs = {"10","0001","111001","1","0"};
        System.out.println(findMaxForm(strs,5,3));
    }
}
