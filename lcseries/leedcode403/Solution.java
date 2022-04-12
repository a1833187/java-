package qrxedu.leedcode403;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    int[][] f;
    int n;
    public boolean canCross(int[] stones) {
        n = stones.length;
        f = new int[n+1][n+1];
        int ans = dfs(stones,0,1);
        return ans == 1;
    }

    /**
     *
     * @param stones:总路线
     * @param s :表示当前处于的位置
     * @param k :表示当前所要跳的步数
     * @return
     */
    public int dfs(int[] stones,int s,int k){
        if(s == n-1){
            return 1;
        }
        int index = Arrays.binarySearch(stones,s+1,stones.length,stones[s]+k);
        if(index < 0){
            return 2;
        }
        int res = 0;
        if(f[s][k] != 0){
            res = f[s][k];
        }else{
            for(int i = k-1; i <= k+1; i++){
                if(i <= 0){
                    continue;
                }
                res = dfs(stones,index,i);
                f[s][k] = res;
                if(res == 1){
                    break;
                }
            }
        }
        return res;
    }
    @Test
    public void show(){
        int[] nums = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(nums));
    }
}
