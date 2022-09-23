package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer10 {
    static final int  MOD = (int)1e9+7;
    public int numWays(int n) {
        int[] f = new int[n+1];
        f[0] = 1;
        for(int i = 0;i < n; i++){
            if(i+1 <= n){
                f[i+1] = (f[i+1]+f[i]) % MOD;
            }
            if(i + 2 <= n){
                f[i+2] = (f[i+2] + f[i]) % MOD;
            }
        }
        return f[n];
    }

    public static void main(String[] args) {

    }
}
