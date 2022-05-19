package qrxedu.leedcode786;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] kthSmallestPrimeFraction1(int[] arr, int _k) {
        int n = arr.length;
        int m = n * (n - 1) / 2;
        int[][] nums = new int[m][2];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                nums[k][0] = arr[i];
                nums[k][1] = arr[j];
                k++;
            }
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double ans1 = (double) o1[0] / o1[1];
                double ans2 = (double) o2[0] / o2[1];
                if (ans1 - ans2 > 0) {
                    return 1;
                } else if (ans1 == ans2) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        return nums[_k - 1];
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double l = 0, r = 1;
        while(true){
            double mid = (l + r) / 2;
            int i = -1,count = 0;
            int x = 0, y = 1;
            for(int j = 1; j < n; j++){
                while((double)arr[i+1]/arr[j] <= mid){
                    i++;
                    if((double)arr[i]/arr[j] > (double)x/y){
                        x = arr[i];
                        y = arr[j];
                    }
                }
                count += i + 1;
            }
            if(count == k){
                return new int[]{x,y};
            }
            if(count > k){
                r = mid;
            }
            if(count < k){
                l = mid;
            }
        }
    }
}

