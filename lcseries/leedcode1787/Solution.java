package qrxedu.leedcode1787;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 修改最少的数组元素的个数使 数组中任意k个连续的元素异或结果为0.
 *  有题 f[i,i+k]的异或结果为0,f[i+1,i+k+1]的结果为0得出 f[i]必须等于 f[i-1] 所以我们可以根据将数组长度对k取模将其分成(0...k-1)k组
 *  每一组中的元素的值必须相同,且相邻k个元素的异或的结果为0
 *  所以状态为f[i][xor] 表示前i列异或结果为xor所需要的最小的元素个数.   最终结果为 f[k-1][0]
 *  每一列中我们 都需要求的最小的元素个数:其共有两种情况,1.将所有元素变为0,f[i][xor] = f[i-1][xor] + 这一列的元素个数
 *                                                2.将这一列中的元素全部变为这一类中某一个元素 f[i][xor] = f[i][xor^cur] + sum - num(cur)
 *                                                 xor^cur^cur = xor.
 *  擦! 这方法也太秀了!!哎---
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int minChanges(int[] nums, int k) {
        int max = 1024;
        int n = nums.length;
        int[] g = new int[k];
        int[][] f = new int[k][max];
        Arrays.fill(g,Integer.MAX_VALUE);
        for(int i = 0; i < k; i++){
            for(int j = 0; j < max; j++){
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < k; i++){
            int cnt = 0;
            Map<Integer,Integer> map = new HashMap<>();
            for(int j = i; j < n;j+=k){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                cnt++;
            }
            if(i == 0){
                for(int xor = 0; xor < max; xor++){
                    f[0][xor] = Math.min(f[0][xor],cnt - map.getOrDefault(xor,0));
                    g[0] = Math.min(f[0][xor],g[0]);
                }
            }else{
                for(int xor = 0; xor < max; xor++){
                    f[i][xor] = g[i-1]+cnt;
                    for(int cur : map.keySet()){
                        f[i][xor] = Math.min(f[i][xor],f[i-1][xor^cur] + cnt - map.get(cur));
                    }
                    g[i] = Math.min(g[i],f[i][xor]);
                }
            }
        }
        return f[k-1][0];
    }
}
