package qrxedu.lcseries.leedcode638;


import java.util.Arrays;
import java.util.List;

/**
 * 状态压缩:n个数的状态组合和这n个数的排列数建立映射(前提是这n个数的每个数的状态都是从0~ki)
 * 对于n1,n2...ni,每个数都有不同的状态,比如n1 = 0,1,2,n2 = 0,1等等,这i个数的状态一共有f[n1]f[n2]...f[ni]种,f[ni]为第i个数的状态种类
 * 如何把这i个数的状态的每个状态用一个整数表示,而且在需要的时候能够根据这个整数解压得到各个物品的状态.
 * g[i]:前i个数的状态和.
 * 设某个状态的排列数位state.则该state下的每个数的具体状态分别为:state % g[i+1] / g[i]
 * 初始状态0,0,...0 的state为0.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        //将各个物品的需求数组合转化为排列数.(状态压缩的一种常见形式)
        int[] g = new int[n+1];
        g[0] = 1;
        //把多个物品的状态转化为排列数
        for(int i = 1; i <= n; i++){
            g[i] = g[i-1]*(needs.get(i-1)+1);
        }
        int mask = g[n];
        int[] f = new int[mask];
        //存放每个状态下各个物品的需求数量
        int[] cnt = new int[n];
        for(int state = 1; state < mask; state++){
            f[state] = Integer.MAX_VALUE;
            Arrays.fill(cnt,0);
            for(int i = 0; i < n; i++){
                //针对每个压缩后的状态进行解压得到各个物品在当前状态下的需求数量.
                cnt[i] = state % g[i+1] / g[i];
            }
            //针对每个单个礼品的求解
            for(int i = 0; i < n; i++){
                if(cnt[i] > 0){
                    f[state] = Math.min(f[state],f[state-g[i]]+price.get(i));
                }
            }
            //针对每个礼包的求解
            out:for(List<Integer> list : special){
                int cur = state;
                for(int i = 0; i < n; i++){
                    int fact = list.get(i);
                    int dd = cnt[i];
                    //题目规定当前状态下的每个物品的个数不能超过当前状态下的需求量
                    //因此如果某个礼包的某个物品的数量大于该状态下的物品的需求数量则直接跳出该礼包的求解
                    if(fact > dd){
                        continue out;
                    }
                    cur-=fact*g[i];
                }
                f[state] = Math.min(f[state],f[cur]+list.get(n));
            }
        }
        return f[mask-1];
    }
}
