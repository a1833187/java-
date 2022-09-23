package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E94 {
    public long maxWater (int[] arr) {
        // write code here
        int n = arr.length;
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = arr[0];
        r[n-1] = arr[n-1];
        for(int i = 1; i < n; i++){
            l[i] = Math.max(l[i-1],arr[i]);
            r[n-1-i] = Math.max(r[n-i],arr[n-i-1]);
        }
        long ans = 0;
        for(int i = 0; i < n; i++){
            ans += Math.min(l[i],r[i])-arr[i];
        }
        return ans;

    }
}
