package com.qrxedu.lcseries.leedcode997;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 寻找秘密法官
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findJudge(int n, int[][] trust) {
        int count = 0;
        if(trust.length == 0){
            if(n!=1) {
                return -1;
            }else{
                return 1;
            }
        }
        ArrayList<Integer> judger = new ArrayList<>();
        for (int j = 1; j <= n; j++) {
            int num = 0;
            for (int i = 0; i < trust.length; i++) {
                if (trust[i][1] == j) {
                    num++;
                }
            }
            judger.add(num);
        }
        for (int i = 0; i < judger.size(); i++) {
            int j = 0;
            if (judger.get(i) == n - 1) {
                for (j = 0; j < trust.length; j++) {
                    if(trust[j][0] == i+1){
                        break;
                    }
                }
            }
            if(j == trust.length){
                return i+1;
            }
        }
        return -1;
    }
    @Test
    public void show(){
        int n = 2;
        int[][] trust = new int[1][2];
        trust[0][0] = 1;
        trust[0][1] = 2;
        System.out.println(findJudge(n,trust));
    }
}
