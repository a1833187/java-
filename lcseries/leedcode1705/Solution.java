package com.qrxedu.lcseries.leedcode1705;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 *给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
 * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
 *
 *
 * 实质是求S(n+k)=S(n)的最大k值
 * @author qiu
 * @version 1.8.0
 * 我的思路：求n次前缀和，找每次前缀和为0的子串对应的最大长度的(右下标)
 * 实际题解：找前缀和中相等的两个距离最长的下标,只需要遍历一次：
 * 原理一致：S(n+k) = S(n) <===> a(n+k)+ .. + a(n+1)
 */
public class Solution {
    public String[] findLongestSubarray(String[] array) {
        int[] arr = new int[array.length];
        //数字对应-1，字母对应1
        /*for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i].charAt(0))) {
                arr[i] = -1;
            } else {
                arr[i] = 1;
            }
        }*/
        int max = 0;
        int res = 0;
        int count = 0;
        int begin = 0;
        int end = 0;
        //所有可能出现的前缀和的值的范围为[-array.length,array.length]
        //tmp中存放的是不同前缀和第一次出现的下标
        //之所以只记录第一次，是因为最长子串的左下标一定是第一次出现的
        int[] tmp = new int[(array.length<<1)+1];
        //下标从0开始，tmp[len]处填充-1的原因是因为求S(n+k)=S(n)的最大k值时,n等于1要另外讨论,所以
        //要虚拟一个前置下标为-1，单项值为0的点去考虑前缀和均为0的两个不同下标的值
        Arrays.fill(tmp,-2);
        tmp[array.length] = -1;
        for (int i = 0; i< arr.length;i++){
            if(isNumber(array[i].charAt(0))){
                count+=-1;
            }else{
                count+=1;
            }
            if(tmp[count+arr.length]<=-2){
                tmp[count+arr.length] = i;
            }else{
                //这里i - tmp[count+arr.length]>res必须为>号不能带=！
                if(i - tmp[count+arr.length]>res){
                    begin = tmp[count+arr.length]+1;
                    end = i+1;
                    res = i - tmp[count+arr.length];
                }
            }
        }
       return Arrays.copyOfRange(array,begin,end);
    }

    public boolean isNumber(char ch) {
        return (ch >= 48 && ch <= 57);
    }

    public int findMax(int[] arr, int l) {
        int[] arr1 = new int[arr.length - l];
        arr1[0] = arr[l];
        for (int i = 1; i < arr1.length; i++) {
            arr1[i] = arr1[i - 1] + arr[i+l];
        }
        int i = arr1.length - 1;
        for (; i >= 0; i--) {
            if (arr1[i] == 0) {
                break;
            }
        }
        return i;
    }
    @Test
    public void show() {
        String[] arr = {"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"};
        String[] arr1 = {"1", "A", "A", "A", "1"};
        System.out.println(Arrays.toString(findLongestSubarray(arr1)));

    }
}
