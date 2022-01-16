package com.qrxedu.lcseries.leedcode397;


/**
 * 给定一个正整数n ，你可以做如下操作：
 *
 * 如果n是偶数，则用n / 2替换n 。
 * 如果n是奇数，则可以用n + 1或n - 1替换n 。
 * n变为 1 所需的最小替换次数是多少？
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    /**
     * timeLimitExceeded(我)
     * @param n
     * @return
     */
    public int integerReplacement(int n) {
        int count = 0;
        while(n!=1){
            if(n%2==0){
                n = n/2;
                count++;
            }else{
                if(n == 3){
                    n = n-1;
                }else{
                    n = judge(n-1)>=judge(n+1)?(n-1):(n+1);
                }
                count++;
            }
        }
        return count;
    }
    public int judge(int n){
        int count = 0;
        while(n/2==0){
            n = n/2;
            count++;
        }
        return count;
    }

    /**
     * 递归解决(中佬)
     * @param n
     * @return
     */
    public int integerReplacement1(int n) {
        int count = 0;
        if(n==1){
            return 0;
        }
        if(n%2==0){
            return (1 + integerReplacement(n/2));
        }
        return 2+Math.min(integerReplacement(n/2),integerReplacement(n/2+1));
    }

    /**
     * 位运算解决(大佬)
     */
    public int integerReplacement2(int n) {
        long temp=n;
        int count=0;
        while(temp!=1){
            if((temp&3)==3&&temp!=3){
                temp++;
            }
            else if((temp&1)==1){
                temp--;
            }
            else{
                temp=temp>>1;
            }
            count++;
        }
        return count;
    }
}
