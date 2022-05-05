package qrxedu.leedcode600;

/**
 * 数位dp:一般形式:[a,b](a<=b)内符合条件的数值个数为多少.通常需要一个dp(int x)求出[0,x]内的情况.
 * 数位dp一般是从高位到低位去考虑
 * 本道题f[i][j]:二进制长度为i,最高位为j的合法值的个数.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    static int[][] f = new int[31][2];
    static{
        f[1][0] = 1;
        f[1][1] = 1;
        for(int i = 1; i < 30; i++){
            f[i+1][0] = f[i][1]+ f[i][0];
            f[i+1][1] = f[i][0];
        }
    }
    public int findIntegers(int n) {
        int k = 0;
        int nn = n;
        while(nn != 0){
            nn>>=1;
            k++;
        }
        int ans = 0;
        int cur = 0,prev = 0;
        for(int i = k; i >= 0; i--){
            cur = (n >> (i-1))&1;
            //这里的含义:第一次是指最高位取0时剩余的所有情况(因为最高位取0一定在[0,n]内)
            //之后每一次将1改为0是指该位的前面位不动,只改变后面的位
            if(cur == 1){
                ans += f[i][0];
            }
            //当有两个相邻的位均为1,再怎么改变低位都不能满足条件,因为已经有连续的1存在了.
            if(prev == 1 && cur == 1){
                break;
            }
            prev = cur;
            //如果i能够到0,那么说明n这个值本身的二进制数中不含连续1,加上即可.
            if(i == 0){
                ans++;
            }
        }
        return ans;
    }

}
