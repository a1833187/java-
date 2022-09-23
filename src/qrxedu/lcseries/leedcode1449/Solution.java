package qrxedu.lcseries.leedcode1449;

/**
 * f[i][j]:前i个数中挑选出成本和恰好为j的最大位数(位数越大,最后组成的数越大)
 * from[i][j]:前i个数中挑选出的成本和恰好为j时前i-1个数的成本值
 * 利用from[i][j]从后往前推:如果from[i][j] == j,说明没有选取第i个数,否则说明选取了第i个数
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String largestNumber(int[] cost, int target) {
        int[][] f = new int[10][target+1];
        int[][] from = new int[10][target+1];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < target+1; j++){
                f[i][j] = Integer.MIN_VALUE;
            }
        }
        //因为可以都不选,所以位数可以都为0
        for(int i = 0;i <= 9; i++){
            f[i][0] = 0;
        }
        for(int i = 1; i <= 9; i++){
            int c = cost[i-1];
            for(int j = 1; j <= target; j++){
                if(c > j){
                    f[i][j] = f[i-1][j];
                    from[i][j] = j;
                }else{
                    //当f[i-1][j] == f[i][j-c]+1时,应该选取第i个数,
                    //因为越往后数越大(1~9) 例如:5和6组合一定小于任意一个数和7组合

                    //和01背包不一样的是,这道题的物品可以无限选取.因此是f[i][j-c]+1而不是f[i-1][j-c]+1
                    if(f[i-1][j] < f[i][j-c]+1){
                        f[i][j] = f[i-1][j];
                        from[i][j] = j;
                    }else{
                        f[i][j] = f[i][j-c]+1;
                        from[i][j] = j-c;
                    }
                }
            }
        }
        if(f[9][target] < 0){
            return "0";
        }
        StringBuilder s = new StringBuilder();
        int i = 9,j = target;
        while(i > 0){
            //如果i被选取了,则退回到前i个数成本为j-cost[i]的情况,因为i有可能多次选取
            //如果i没有被选取,则退回到前i-1个数,成本为j的情况
            if(j != from[i][j]){
                //这里不需要考虑说 多次选取了某一个值,因为如果这个值被选取了,
                s.append(i);
                j = from[i][j];
            }else{
                i--;
            }
        }
        return new String(s);
    }
}
