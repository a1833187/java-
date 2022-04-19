package qrxedu.leedcode1995;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 寻找符合条件的四元组.
 * 这种题目和两数之和很像,都是以中间元素为遍历基础,利用哈希表存储后续元素出现的个数,遍历前面元素
 * 来降低时间复杂度.
 * 要根据题目要求看哈希表初始化的位置,如果严格要求必须在后面,则必须要遍历的过程中进行初始化.
 * 如果只是为了找到符合条件的值的下标,则可以在遍历前直接对哈希表进行初始化(两数之和)
 * 如果对数据之间的前后顺序无要求并且最终求得的是个数或者值而非下标,则可以通过排序+双指针遍历第二小元素
 * 实现(三数之和,三数之和要求的三元组不能重复也可以暴力的用set结构来满足)
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int countQuadruplets(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int ans = 0;
        for(int i = n-3; i > 0; i--){
            for(int k = i+2;k<n;k++){
                map.put(nums[k]-nums[i+1],map.getOrDefault(nums[k]-nums[i+1],0)+1);
            }
            for(int j = 0; j < i; j++){
                ans+=map.getOrDefault(nums[i]+nums[j],0);
            }
        }
        return ans;
    }

    public int countQuadruplets2(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int ans = 0;
        for(int k = n-2; k>=2;k--){
            map.put(nums[k+1],map.getOrDefault(nums[k+1],0)+1);
            for(int i = 0; i < k; i++){
                for(int j = i+1; j< k; j++){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(map.get(sum)!=null){
                        ans+=map.get(sum);
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 多维背包
     * f[i][j][k]:前i个物品和为j且个数恰好为k的个数.
     * @param nums
     * @return
     */
    public int countQuadruplets1(int[] nums) {
        int n = nums.length;
        int[][][] f = new int[n+1][110][4];
        f[0][0][0] = 1;
        for(int i = 1; i <= n; i++){
            int num = nums[i-1];
            for(int k = 0; k < 110; k++) {
                for (int j = 0; j < 4; j++) {
                    f[i][k][j] += f[i-1][k][j];
                    if(k-num >= 0 && j-1>=0){
                        f[i][k][j]+=f[i-1][k-num][j-1];
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 3; i < n; i++){
            ans+=f[i][nums[i]][3];
        }
        return ans;
    }
}
