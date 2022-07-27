package qrxedu.e101;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E73 {
    public int getLongestPalindrome (String A) {
        // write code here
        int n = A.length();
        int[][] f = new int[n][n];
        for(int i = 0; i < n; i++){
            f[i][i] = 1;
        }
        int ans = 1;
        //l为长度-1,i为起始下标,判断f[i][j]是否是字符串,是则在判断l+1与ans的大小关系
        for(int l = 0; l < n; l++){
            for(int i = 0; i < n - 1; i ++){
                int j = i + l;
                if(j >= n){
                    break;
                }
                if(l == 0){
                    f[i][j] = 1;
                }else if(l == 1){
                    f[i][j] = A.charAt(i) == A.charAt(j) ? 1 : 0;
                }else{
                    if(A.charAt(i) == A.charAt(j) && f[i+1][j-1] == 1){
                        f[i][j] = 1;
                    }
                }
                if(f[i][j] == 1 && l + 1 > ans){
                    ans = l + 1;
                }
            }
        }
        return ans;
    }
    @Test
    public void show(){
        String s = "ccbcabaabba";
        System.out.println(getLongestPalindrome(s));
    }
}
