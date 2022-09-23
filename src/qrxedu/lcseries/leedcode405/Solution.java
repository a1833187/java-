package qrxedu.lcseries.leedcode405;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 转换进制
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println((int)(2e31-1));
        long a = (long)Integer.MAX_VALUE-Integer.MIN_VALUE;
        System.out.println(a);
        System.out.println(a / 16 % 16);
    }
    public String toHex1(int num) {
        //常规利用栈转换进制.
        long ans = 0;
        if(num < 0){
            ans = (long)Integer.MAX_VALUE - Integer.MIN_VALUE+1+num;
        }else{
            ans = (long)num;
        }
        Deque<Character> stack = new LinkedList<>();
        while(ans != 0){
            long tmp = ans % 16;
            if(tmp < 10){
                stack.push((char) ('0'+tmp-10));
            }else{
                stack.push((char)('a'+tmp-10));
            }
            ans /= 16;
        }
        StringBuilder s = new StringBuilder();
        while(!stack.isEmpty()){
            s.append(stack.pop());
        }
        return new String(s);

    }
    public String toHex(int num){
        //利用位运算转换进制,每四位一组进行转换.
        if(num == 0){
            return "0";
        }
        StringBuilder s = new StringBuilder();
        for(int i = 7; i >= 0; i--){
            int val = (num>>(4*i)) & 0xf;
            //不能有前导0
            if(!(s.length() == 0 && val == 0)){
                s.append(val < 10 ? (char)('0'+val) : (char)('a'+val-10));
            }
        }
        return new String(s);
    }
    @Test
    public void show(){
        System.out.println(toHex(-1));
    }
}
