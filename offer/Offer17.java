package qrxedu.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer17 {
    public int[] printNumbers(int n) {
        int end = (int)Math.pow(10,n);
        int[] ans = new int[end-1];
        for(int i = 1; i < end ;i++){
            ans[i-1] = i;
        }
        return ans;
    }
}
