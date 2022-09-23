package qrxedu.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer45 {
    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        String ans = "";
        for(String str : s){
            ans += str;
        }
        return ans;
    }
}
