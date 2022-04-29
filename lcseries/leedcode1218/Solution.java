package qrxedu.leedcode1218;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int m = arr.length;
        int[] f = new int[m];
        Arrays.fill(f, 1);
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0] + difference, 1);
        for (int i = 1; i < m; i++) {
            if (map.containsKey(arr[i])) {
                f[i] = map.get(arr[i]) + 1;
            }
            //因为本身最近添加的对应等差的就是长度最长的,所以不需要再判断那个长度更长了
            map.put(arr[i]+difference,f[i]);
//            if (map.containsKey(arr[i] + difference)) {
//                int cur = map.get(arr[i] + difference);
//                if (cur < f[i]) {
//                    map.put(arr[i] + difference, f[i]);
//                }
//            }else{
//                map.put(arr[i]+difference,f[i]);
//            }
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
