package qrxedu.offer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer14 {
    public int cuttingRope(int n) {
        //f[i] 表示长度为i的绳子的最大乘积.
        int[] f = new int[n+1];
        for(int i = 2; i <= n; i++){
            int max = 0;
            for(int j = 1; j < i; j++){
                //(i-j)表示把i切成2份,f[i-j]表示把i切成f[i-j]中切出的份数+1(大于2)
                max = Math.max(max,Math.max(j*(i-j),j * f[i-j]));
            }
            f[i] = max;
        }
        return f[n];
    }
    public int cuttingRope1(int n){
        //把n切成k份,当k是确定的时候,尽可能的将n切分成k均等份后,k份的乘积最大
        //所以遍历份数求最大乘积
        int ans = 0;
        for(int i = 2; i < n; i++){
            int r = n % i;
            int c = n / i;
            int cnt = 0;
            int x = c + 1;
            while(r != 0){
                cnt++;
                r--;
            }
            ans = Math.max(ans,(int)Math.pow(c,i-cnt)*(int)Math.pow(x,cnt));
        }
        return ans;
    }
}
