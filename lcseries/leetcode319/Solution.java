package com.qrxedu.lcseries.leetcode319;

/**
 * 初始时有n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭一个。
 * 第三轮，你每三个灯泡就切换一个灯泡的开关（即，打开变关闭，关闭变打开）。
 * 第 i 轮，你每 i 个灯泡就切换一个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
 * 找出并返回 n轮后有多少个亮着的灯泡。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int bulbSwitch(int n) {
        int[] bulbs = new int[n+1];
        //1表示灯为亮,-1表示灯灭
        for(int i = 1; i <= n; i++){
            bulbs[i] = 1;
        }
        for(int i = 2; i <= n; i++){
            for(int j = i; j <= n; j+=i){
                bulbs[j] = -bulbs[j];
            }
        }
        int count = 0;
        for(int i = 1; i <= n;i++){
            if(bulbs[i] == 1){
                count++;
            }
        }
        return count;

        //找规律: return Math.sqrt(n);
    }

}
