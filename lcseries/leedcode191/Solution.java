package qrxedu.leedcode191;

/**
 * SWAR算法:实现log(k)复杂度
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int hammingWeight(int n) {
        int cnt = 0;
        for(int i = 0; i < 32; i++){
            int w = (n >> i) & 1;
            if(w == 1){
                cnt++;
            }
        }
        return cnt;
    }
    public int hammingWeight1(int n){
        //SWAR算法:采取分治思想,
        /* 先考虑每两位上1比特的数量 0x55555555 --  010101010101..01
           再考虑每四位上1比特的数量 0x33333333 --  00110011...0011
           ...八..                0x0F0F0F0F --  00001111..00001111
           ...十六                0x00FF00FF -- 0000000011111111..
           ...三十二              0x0000FFFF -- 00.000111...1
         */
        //每组高位1加上低位1
        //得到值的每两位转为十进制相加得到数就是结果
        n = (n & 0x55555555) + ((n >> 1) & 0x55555555);
        //得到值的每四位转为十进制相加得到数就是结果
        n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
        n = (n & 0x0F0F0F0F) + ((n >> 4) & 0x0F0F0F0F);
        n = (n & 0x00FF00FF) + ((n >> 8) & 0x00FF00FF);
        n = (n & 0x0000FFFF) + ((n >> 16) & 0x0000FFFF);
        return n;
    }
}
