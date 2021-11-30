package com.qrxedu.leedcode400;

import org.junit.jupiter.api.Test;

/**
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...]
 * 中找出并返回第 n 位上的数字。
 * @author qiu
 * 解题思路：
 * 先求第n个数所在的区间的数字由几位组成；
 * 然后在定义到这个区间的具体某一个数字，
 * 然后再定义到某个数字的某一位
 * @version 1.8.0
 */
public class Solution {
    public int findNthDigit(int n) {
        if(n <= 9){
            return n;
        }
        int start = 0;
        int end = 9;
        int i;
        for(i = 2; i <=9;i++){
            start+=9*(i-1)*Math.pow(10,i-2);
            end+=9*i*Math.pow(10,i-1);
            if(n>=start&&n<=end){
                break;
            }
        }
        int index = n - start;
        int s = (int)Math.pow(10,i-1);
        int d = s + (index-1)/i;
        int r = (index-1) %i;
        return (d/(int)Math.pow(10,i-1-r))%10;
    }
    @Test
    public void show(){
        System.out.println(findNthDigit(15));
    }
}
