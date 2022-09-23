package qrxedu.lcseries.leedcode357;

import org.junit.jupiter.api.Test;


/**
 * 排列组合
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int cnt = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            cnt += cur;
        }
        return cnt;
    }

    @Test
    public void show() {
        System.out.println(countNumbersWithUniqueDigits(3));
    }
}
