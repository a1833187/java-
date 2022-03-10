package qrxedu.leedcode322;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int count = 0;

    public int coinChange(int[] coins, int amount) {
        if (coins == null) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (coins.length == 1 && (coins[0] > amount || amount % coins[0] != 0)) {
            return -1;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i = 1;i<=amount;i++){
            for(int j = 0; j < coins.length;j++){
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 :dp[amount];
    }

    @Test
    public void show() {
        int[] coins = {186, 419, 83, 408};
        System.out.println(coinChange(coins, 6249));
    }
}
