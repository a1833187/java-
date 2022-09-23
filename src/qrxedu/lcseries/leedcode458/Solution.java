package qrxedu.lcseries.leedcode458;

/**
 * 可怜的小猪
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int m = minutesToTest/minutesToDie+1;
        int o = (int)Math.ceil(Math.log(buckets)/Math.log(m));
        return o;
    }
}
