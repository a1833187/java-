package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E64 {
    public int minCostClimbingStairs (int[] cost) {
        // write code here
        int n = cost.length;
        if(n == 1){
            return cost[0];
        }
        int[] f = new int[n+1];
        for(int i = 2; i <= n; i++){
            f[i] = Math.min(f[i-1]+cost[i-1],f[i-2]+cost[i-2]);
        }
        return f[n];
    }
}
