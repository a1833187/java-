package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer58 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int cur = 0;
            for(int num : nums){
                cur += ((num >> i) & 1);
                cur %= 3;
            }
            ans += (cur << i);
        }
        return ans;
    }

    //有限状态自动机:将三种形式分别用00,01,10来代替.通过列举有限的变化状态推出公式推导
    public int singleNumber1(int[] nums) {
        int one = 0;
        int two = 0;
        for(int num : nums){
            one = one ^ num & ~two;
            two = two ^ num & ~one;
        }
        return one;
    }
}
