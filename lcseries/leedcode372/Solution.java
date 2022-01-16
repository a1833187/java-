package com.qrxedu.lcseries.leedcode372;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int res = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            res = (int) (( (long)res * pow(a, b[i])) % MOD);
            a = pow(a, 10);
        }
        return res;
    }

    public int pow(int a, int n) {
        //快速幂取模
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) (((long) res * a) % MOD);
            }
            a = (int) (((long)a * a) % MOD);
            n = n / 2;
        }
        return res;
    }

    public int fastPower(int a, int n) {
        //快速幂(O(logn))
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) (((long) res * a));
            }
            a = (int) (((long) a * a));
            n = n / 2;
        }
        return res;
    }

    @Test
    public void show() {
        System.out.println(superPow(Integer.MAX_VALUE, new int[]{1, 2, 3, 4, 5, 6}));
    }
}
