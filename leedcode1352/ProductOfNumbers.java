package com.qrxedu.leedcode1352;

import java.util.ArrayList;

/**
 * 这道题。。有点没get到中等难度难在哪。。
 * @author qiu
 * @version 1.8.0
 */
public class ProductOfNumbers {
    ArrayList<Integer> arr = new ArrayList<>();
    public ProductOfNumbers() {

    }

    /**
     * 将数字 num 添加到当前数字列表的最后面。
     * @param num
     */
    public void add(int num) {
        arr.add(num);
    }

    /**
     * 返回当前数字列表中，最后 k 个数字的乘积。
     * 你可以假设当前列表中始终 至少 包含 k 个数字
     * @param k
     * @return
     */
    public int getProduct(int k) {
        int len = arr.size();
        int mult = 1;
        for(int i = 1; i<=k;i++){
            mult*=arr.get(len-i);
        }
        return mult;
    }
}
