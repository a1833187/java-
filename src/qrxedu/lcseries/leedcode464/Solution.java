package qrxedu.lcseries.leedcode464;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Solution {
    int m;
    //dp中的数字已经能够表示当前进行的"轮数"
    Boolean[] dp;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal <= maxChoosableInteger){
            return true;
        }
        if((1+maxChoosableInteger)*maxChoosableInteger/2 < desiredTotal){
            return false;
        }
        m =  maxChoosableInteger;
        dp = new Boolean[1<<m];
        return dfs(desiredTotal,0);
    }
    public boolean dfs(int d,int state){
        if(dp[state] != null){
            return dp[state];
        }
        for(int i = 1; i <= m; i++){
            int cur = 1 << (i-1);
            if(state >> (i-1) == 0){
                //自己已经赢了或者对手输了说明自己都赢了.
                if(d - i <= 0 || !dfs(d-i,state|cur)){
                    return dp[state] = true;
                }
            }
        }
        return dp[state] = false;
    }
}
