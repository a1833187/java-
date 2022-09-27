package qrxedu.lcseries.leedcode525;

import java.util.HashMap;
import java.util.Map;

/**
 * 两种数字(也可以是别的类型),找数量相同的:把1个的值改成1,1个的值改为-1,前缀和相减为0
 * 前缀和,化0为-1
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int counter = 0;
        map.put(counter,-1);
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                counter++;
            }else{
                counter--;
            }
            if(map.containsKey(counter)){
                ans = Math.max(ans,i-map.get(counter));
            }else{
                map.put(counter,i);
            }
        }
        return ans;

    }
}
