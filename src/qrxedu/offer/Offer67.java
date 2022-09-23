package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 * f[n] = (f[n-1]+m)%n
 */
public class Offer67 {
    public int lastRemaining(int n, int m) {
        int x = 0;
        for(int i = 2; i <= n; i++){
            x = (x + m) % i;
        }
        return x;
    }
}
