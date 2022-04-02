package qrxedu.wexam;

import java.util.Stack;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main9 {
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            if(A.charAt(i) == '('){
                stack.push(A.charAt(i));
            }else if(A.charAt(i) == ')'){
                if(!stack.empty()){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return stack.empty();
    }
}
