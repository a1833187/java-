package com.qrxedu.leedcode59;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int total = n * n;
        int top = 0,bottom = n - 1;
        int left = 0,right = n - 1;
        int count = 0;
        while(total >= 1){
            for(int i = left; i <=right&&total>=1;i++){
                nums[top][i] = ++count;
                total--;
            }
            top++;
            for(int i = top; i <= bottom && total >= 1;i++){
                nums[i][right] = ++count;
                total--;
            }
            right--;
            for(int i = right; i >= left && total >= 1;i--){
                nums[bottom][i] = ++count;
                total--;
            }
            bottom--;
            for(int i = bottom; i>=top && total >= 1; i--){
                nums[i][left] = ++count;
                total--;
            }
            left++;
        }
        return nums;
    }
}
