package com.qrxedu.leedcode384;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] nums;
    public int[] copy;
    public Solution(int[] nums) {
        this.nums = nums;
    }

    /**
     * 等概率重设数组到它的初始状态并返回
     * @return
     */
    public int[] reset() {
        int len = nums.length;
        copy = new int[len];
        for(int i = 0; i < len; i++){
            copy[i] = nums[i];
        }
        return copy;
    }

    /**
     * Fisher-Yates 洗牌算法
     * 返回数组随机打乱后的结果
     * @return
     */
    public int[] shuffle() {
        Random random = new Random();
        int[] copy = nums;
        for(int i = 0; i < nums.length; i++){
            copy[i] = nums[i];
        }
        for(int i = 0; i < copy.length;i++){
            int j = i + random.nextInt(copy.length-i);
            int temp = copy[i];
            copy[i] = copy[j];
            copy[j] = temp;
        }
        return copy;
    }
        //暴力随机,条件概率
        /*ArrayList<Integer> arr = new ArrayList<>();
        int len = nums.length;
        copy = new int[len];
        for(int i = 0; i < len; i++){
            arr.add(nums[i]);
        }
        Random random = new Random();
        for(int i = 0; i < len ; i++){
            int j = random.nextInt(arr.size());
            System.out.println(arr);
            copy[i] = arr.remove(j);
        }
        return copy;
    }*/
}
