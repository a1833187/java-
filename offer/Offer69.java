package qrxedu.offer;

/**
 * 不使用乘除法和循环,条件语句实现1+2+..+n
 * 递归  +  利用&& 的短路效应(代替递归语句的判断结束语句if)
 * @author qiu
 * @version 1.8.0
 */
public class Offer69 {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n-1)) > 0;
        return n;
    }
}
