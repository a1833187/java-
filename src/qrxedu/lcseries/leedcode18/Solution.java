package qrxedu.lcseries.leedcode18;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int ll = 0;ll < n; ll++) {
            if (ll > 0 && nums[ll] == nums[ll - 1]) {
                continue;
            }
            for (int l = ll + 1; l < n; l++) {
                if (l - 1 > ll && nums[l] == nums[l - 1]) {
                    continue;
                }
                int r = l + 1;
                int rr = n - 1;
                while (r < rr) {
                    long sum = (long)nums[ll] + (long)nums[l] + (long)nums[r] + (long)nums[rr];

                    if (sum <= target) {
                        if (sum == target) {
                            List<Integer> cur = new ArrayList<>();
                            cur.add(nums[ll]);
                            cur.add(nums[l]);
                            cur.add(nums[r]);
                            cur.add(nums[rr]);
                            list.add(cur);
                        }
                        r++;
                    } else if (sum > target) {
                        rr--;

                    }
                }
            }
        }
        return list;
    }
    @Test
    public void show(){
        //[1000000000,1000000000,1000000000,1000000000]
        //-294967296
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum(nums,-294967296));
    }
}
