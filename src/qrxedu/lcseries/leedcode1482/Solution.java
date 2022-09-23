package qrxedu.lcseries.leedcode1482;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < m * k){
            return -1;
        }
        int r = 0;
        int l = Integer.MAX_VALUE;
        for(int num : bloomDay){
            r = Math.max(r,num);
            l = Math.min(l,num);
        }
        while(l < r){
            int mid = l + r >> 1;
            if(check(mid,bloomDay,m,k)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    public boolean check(int mid,int[] arr,int m,int k){
        //贪心
        int n = arr.length;
        int ans = 0;
        int cur = 0;
        for(int i = 0; i < n && ans < m; i++){
            if(arr[i] <= mid){
                cur++;
                if(cur == k){
                    ans++;
                    cur = 0;
                }
            }else{
                cur = 0;
            }
        }
        return ans >= m;
    }
}
