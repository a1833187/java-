package qrxedu.lcseries.leedcode1994;

/**
 * 状态压缩的一种常见形式:当可选集个数有限时,可以从小到大把它对应到二进制上.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    int[] dict = {2,3,5,7,11,13,17,19,23,29};
    int MOD = (int)1e9+7;
    int[] cnts = new int[31];
    public int numberOfGoodSubsets(int[] nums) {
        int mask = 1<<10;
        long[] f = new long[mask];
        for(int i : nums){
            cnts[i]++;
        }
        f[0] = 1;
        for(int i = 2; i <= 30; i++){
            if(cnts[i] == 0){
                continue;
            }
            int cur = 0;
            int x = i;
            boolean ok = true;
            for(int j = 0; j < 10; j++){
                int c = 0;
                int d = dict[j];
                //将该值的质数乘积的二进制形式表示出来
                while(x % d == 0){
                    cur |= (1<<j);
                    x/=d;
                    c++;
                }
                if(c > 1){
                    ok = false;
                    break;
                }
            }
            if(!ok){
                continue;
            }
            for(int prev = mask-1;prev >= 0;prev--){
                //从后往前遍历就和 01背包一维化一样
                //在prev&cur==0的情况下 prev^cur 一定大于prev ,如果从前
                //往后遍历,在遍历后面的prev^cur时,可能用到的前面的prev被提前更新过.
                if((prev&cur)==0){
                    f[prev^cur] = (f[prev^cur]+f[prev]*cnts[i])%MOD;
                }
            }
        }
        long ans = 0;
        //统计非空集合.
        for(int i = 1; i < mask; i++){
            ans = (ans+f[i])%MOD;
        }
        //1对乘积无影响,所以每个1对应有两种情况:选或者不选.
        for(int i = 0; i < cnts[1]; i++){
            ans = (ans * 2) % MOD;
        }
        return (int)ans;

    }
}
