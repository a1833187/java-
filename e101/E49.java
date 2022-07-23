package qrxedu.e101;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E49 {
    public int solve (String s) {
        // write code here
       s = s.trim();
       Deque<Integer> stack = new ArrayDeque<>();
       int number = 0;
       char sign = '+';
       char[] arr = s.toCharArray();
       for(int i = 0, n = s.length(); i < n; i++){
           char c = arr[i];
           if(c == ' '){
               continue;
           }
           if(Character.isDigit(c)){
                number = number * 10 + c - '0';
           }
           if(c == '('){
               int j = i + 1;
               int count = 1;
               while(count > 0){
                   if(arr[j] == '('){
                       count++;
                   }
                   if(arr[j] == ')'){
                       count--;
                   }
                   j++;
               }
               number = solve(s.substring(i+1,j-1));
               i = j - 1;
           }
           if(!Character.isDigit(c) || i == n - 1){
               if(sign == '+'){
                   stack.push(number);
               }else if(sign == '-'){
                   stack.push(-1 * number);
               }else if(sign == '*'){
                   stack.push(stack.pop() * number);
               }
               number = 0;
               sign = c;
           }
       }
       int ans = 0;
       while(!stack.isEmpty()){
           ans += stack.pop();
       }
       return ans;

    }
    @Test
    public void show(){
        String s = "(3+4)*(5+(2-3))";
        System.out.println(solve(s));
    }
}
