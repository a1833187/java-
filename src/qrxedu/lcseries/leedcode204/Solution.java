package qrxedu.lcseries.leedcode204;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    //素数快速判断
    public int countPrimes(int n) {
        int cnt = 0;
        for(int i = 2; i < n; i++){
            if(isPrime(i)){
                cnt++;
            }
        }
        return cnt;
    }
    public boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        if(n == 2 || n == 3){
            return true;
        }
        if(n % 6 != 1 && n % 6 != 5){
            return false;
        }
        for(int i = 5; i * i <= n; i+=6){
            if(n % i == 0 || n % (i+2) == 0){
                return false;
            }
        }
        return true;
    }


    //埃式筛
    static int N = 5000005;
    static boolean[] isPrime = new boolean[N];
    static{
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i < N; i++){
            if(isPrime[i]){
                for(int j = 2*i;j < N; j+=i){
                    if(isPrime[j]){
                        isPrime[j] = false;
                    }
                }
            }
        }
    }
    public int countPrimes1(int n) {
        int cnt = 0;
        for(int i = 2; i < n; i++){
            if(isPrime[i]){
                cnt++;
            }
        }
        return cnt;
    }
}
