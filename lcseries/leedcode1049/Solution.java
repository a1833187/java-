package qrxedu.leedcode1049;

/**
 * 最后一块石头的重量
 * 两两粉碎石头的规则可以等价为给这堆石头添加+-号使最后结果的绝对值最小(这个我倒是想出来了..
 * 就是没想到怎么和背包问题联系起来...)
 * 我们设总的石头重量和为sum,前面为-号的的石头的重量和为sum1,那么前面为+号的石头的重量和为sum-sum1
 * 所以问题转换为abs(sum-2sum1)最小,也就是让sum1在不超过sum/2的前提下尽可能的大
 * 可以等价为在背包不超过sum1的前提下,物品的价值和重量均为stones[i]时能够装进背包的最大价值
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int num :stones){
            sum+=num;
        }
        int m = stones.length;
        int n = sum/2;
        int[][] f = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(j < stones[i-1]){
                    f[i][j] = f[i-1][j];
                }else{
                    f[i][j] = Math.max(f[i-1][j],f[i-1][j-stones[i-1]]+stones[i-1]);
                }
            }
        }
        return Math.abs(sum-f[m][n]-f[m][n]);
    }
}
