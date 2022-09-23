package qrxedu.lcseries.leedcode306;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for (int secondStart = 1; secondStart < len - 1; secondStart++) {
            if (num.charAt(0) == '0' && secondStart != 1) {
                break;
            }
            for (int secondEnd = secondStart; secondEnd < len - 1; secondEnd++) {
                if (num.charAt(secondStart) == '0' && secondEnd != secondStart) {
                    break;
                }
                if (isAdd(secondStart,secondEnd,num)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAdd(int secondStart, int secondEnd, String num) {
        int len = num.length();
        int firstStart = 0;
        int firstEnd = secondStart - 1;
        while(secondEnd < len - 1) {
            String third = addString(firstStart, firstEnd, secondStart, secondEnd, num);
            int thirdStart = secondEnd + 1;
            int thirdEnd = thirdStart + third.length() - 1;
            if(thirdEnd >= len || !num.substring(thirdStart,thirdEnd + 1).equals(third)){
                break;
            }
            if(thirdEnd == len - 1){
                return true;
            }
            firstStart = secondStart;
            firstEnd = secondEnd;
            secondStart = thirdStart;
            secondEnd = thirdEnd;
        }
        return false;
    }

    public String addString(int firstStart,int firstEnd,int secondStart, int secondEnd, String num) {
        int len = num.length();
        StringBuilder third = new StringBuilder();
        int p = 0, cur = 0;
        while (secondEnd >= secondStart||firstEnd >= firstStart||cur != 0){
            if(firstEnd >= firstStart){
                cur += num.charAt(firstEnd) - '0';
                firstEnd--;
            }
            if(secondEnd >= secondStart){
                cur += num.charAt(secondEnd) - '0';
                secondEnd--;
            }
            p = cur % 10;
            third.append((char) (p+'0'));
            cur/=10;
        }
        third.reverse();
        return third.toString();
    }
    @Test
    public void show(){
        String num = "199100199";
        System.out.println(isAdditiveNumber(num));
    }
}
