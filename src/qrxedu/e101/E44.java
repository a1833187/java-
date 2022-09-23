package qrxedu.e101;

import java.util.Stack;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E44 {
    public boolean isValid (String s) {
        // write code here
        if(s == null || s.length() == 0){
            return true;
        }
        int n = s.length();
        Stack<Character> s1 = new Stack<>();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                s1.push(ch);
            }
            if(ch == ')'){
                if(s1.size() != 0 && s1.peek() == '('){
                    s1.pop();
                }else{
                    return false;
                }
            }
            if(ch == ']'){
                if(s1.size() != 0 && s1.peek() == '['){
                    s1.pop();
                }else{
                    return false;
                }
            }
            if(s1.size() != 0 && ch == '}'){
                if(s1.peek() == '{'){
                    s1.pop();
                }else{
                    return false;
                }
            }
        }
        return s1.empty();
    }
}
