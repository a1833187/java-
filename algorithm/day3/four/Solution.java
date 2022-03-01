package qrxedu.algorithm.day3.four;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Solution {
    /*
        最优解法：
        统一1个整数的二进制表示(补码)的1的个数
        让n与n-1按位与可以直接检测到n的二进制中的第一个1，然后依次检测
     */
    public int numberOf1(int n){
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
    /*
    让n与1按位与判断n的最低位是否为1，然后依次遍历,这样做得遍历n的所有二进制位
    public int numberOf1(int n){
        int count = 0;
        int flag = 1;
        while(n != 0){
            if(n & flag == 1){
                count++;
            }
            n = n>>2;
        }
    }

     */
}
