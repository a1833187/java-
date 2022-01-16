package com.qrxedu.lcseries.leedcode598;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int res = m * n;
        if(ops.length == 0){
            return res;
        }
        int rmin = ops[0][0];
        int cmin = ops[0][1];
        for(int i = 0; i < ops.length;i++){
            if(rmin > ops[i][0]){
                rmin = ops[i][0];
            }
            if(cmin > ops[i][1]){
                cmin = ops[i][1];
            }
        }
        return rmin * cmin;
    }

    @Test
    public void show() {

    }
}
