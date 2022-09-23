package qrxedu.lcseries.leedcode258;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int addDigits(int num) {
        if(num == 0){
            return 0;
        }
        if(num % 9 == 0){
            return 9;
        }else{
            return num % 9;
        }
    }
}
