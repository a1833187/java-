package qrxedu.algorithm.day13.one;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int minNumOfH(String s){
        int[] minNums = new int[s.length()+1];
        boolean[][] isPal = new boolean[s.length()+1][s.length()+1];
        for(int i = 1; i <= s.length();i++){
            isPal[i][i] = true;
        }
        for(int i = s.length(); i > 0; i--){
            for(int j = s.length(); j >= i+1; j--){
                if(j == i + 1){
                    isPal[i][j] = s.charAt(i-1) == s.charAt(j-1);
                    break;
                }
                if(s.charAt(i-1) != s.charAt(j-1)){
                    isPal[i][j] = false;
                }else{
                    isPal[i][j] = isPal[i+1][j-1];
                }
            }
        }
        Arrays.fill(minNums,s.length()-1);
        minNums[0] = -1;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i;j++){
                //这里的两层循环里还要判断是否回文，所以时间复杂度为O(n^3),可以事先把每个子串是否为回文串
                //统计出来，到这里直接用，达到用空间换时间的效果
                //if(isPal[j+1][i])
                if(isH(s,j+1,i)){
                    minNums[i] = Math.min(minNums[i],minNums[j] + 1);
                }
            }
        }
        return minNums[s.length()];
    }
    public boolean isH(String str,int start,int end){
        while(start < end){
            if(str.charAt(start)!= str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
