package qrxedu.lcseries.leedcode150;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        while(true){
            if(isOper(tokens[index])){
                num1 = stack.pop();
                num2 = stack.pop();
                res = operation(num1,num2,tokens[index]);
                stack.push(res);
            }else{
                stack.push(Integer.parseInt(tokens[index]));
            }
            if(index == tokens.length-1){
                break;
            }
            index++;
        }
        return stack.pop();
    }
    public boolean isOper(String s){
        return "+".equals(s)||"-".equals(s)||"*".equals(s)||"/".equals(s);
    }
    public int operation(int num1,int num2,String s){
        //注意传入参数的顺序,当处理减法或者是除法时不能弄反！！
        if("+".equals(s)){
            return num1+num2;
        }
        if("-".equals(s)){
            return num2-num1;
        }
        if("*".equals(s)){
            return num1*num2;
        }
        if("/".equals(s)){
            return num2/num1;
        }
        return -1;
    }

    @Test
    public void show(){
        String[] s = new String[]{
                "4","6","5","/","+"
};
        System.out.println(evalRPN(s));
    }
}
