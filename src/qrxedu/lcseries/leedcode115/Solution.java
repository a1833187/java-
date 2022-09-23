package qrxedu.lcseries.leedcode115;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int count = 0;
    public StringBuffer sb = new StringBuffer();

    /**
     * 回溯可以解决，不过时间复杂度太大了，TL
     * @param s
     * @param t
     * @return
     */
    public int numDistinct1(String s, String t) {
        dfs(s,t,0);
        return count;
    }
    public void dfs(String s,String t,int index){
        if(sb.length() == t.length()){
            if(sb.toString().equals(t)){
                count++;
            }
            return;
        }
        for(int i = index; i < s.length();i++){
            sb.append(s.charAt(i));
            dfs(s,t,i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public int numDistinct(String s,String t){
        int m = s.length();
        int n = t.length();
        int[][] nums = new int[m+1][n+1];
        for(int i = 0; i<= n; i++){
            nums[0][i] = 0;
        }
        for(int i = 0; i <= m; i++){
            nums[i][0] = 1;
        }
        for(int j = 1; j <= n;j++){
            for(int i = j; i <= m; i++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    nums[i][j] = nums[i-1][j-1] + nums[i-1][j];
                }else{
                    nums[i][j] = nums[i-1][j];
                }
            }
        }
        return nums[m][n];
    }
    @Test
    public void show(){
        String s = "dbaaadcddccdddcadacbadbadbabbbcad";
        String t = "dadcccbaab";
        System.out.println(numDistinct1(s,t));
    }
}
