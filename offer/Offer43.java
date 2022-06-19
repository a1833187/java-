package qrxedu.offer;

/**
 * 分别考虑每一个数位上取1的个数
 * 解释:1234567:假设考虑百位上1的个数
 * 首先将1234567分成0~1234000和1234001~1234567
 * 前半部分:百位以下0~999每一个循环百位上出现的1的次数为100(100~199),共有1234个循环,所以百位上一共
 * 有1234*100个1
 * 后半部分000~567,百位上出现1的次数可以分为以下几种情况:首先567(n')可以通过n%1000得到
 * 1.n'小于100:百位上0个1
 * 2.n'∈ [100,200):百位上n'-100+1个1
 * 3.n'>=200:百位上:100个1
 * 综上可以得到百位上1的个数为min(max(0,n'-100+1),100)
 * 所以百位上1的个数为1234*100+min(max(0,n'-100+1),100),统计所有数位上可能出现的1的次数然后求和
 * @author qiu
 * @version 1.8.0
 */
public class Offer43 {
    public int countDigitOne(int n) {
        int ans = 0;
        long mulk = 1;
        while(n >= mulk){
            ans += (n/(mulk*10))*(mulk) + Math.min(Math.max(n%(mulk*10)-mulk+1,0),mulk);
            mulk*=10;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
