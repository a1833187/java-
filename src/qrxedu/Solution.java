package qrxedu;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * [1,2,3,2,2,2,5,4,2]
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0){
            return 0;
        }
       int time = 1;
       int num = array[0];
       for(int i = 1; i < array.length; i++){
           if(time == 0){
               time = 1;
               num = array[i];
           }else if(num == array[i]){
               time++;
           }else{
               time--;
           }
       }
       return num;
    }

    public int calculate(String s) {
        Deque<Integer> numS = new LinkedList<>();
        Deque<Character> symS = new LinkedList<>();

        StringBuilder curS = new StringBuilder(s);
        int k = 0;
        while(k < curS.length()){
            if(curS.charAt(k) == ' '){
                curS.deleteCharAt(k);
            }else{
                k++;
            }
        }
        s = new String(curS);
        int n = s.length();
        if(s.charAt(0) == '-'){
            numS.push(0);
        }
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                continue;
            }
            if(ch == '+' || ch == '-'){
                symS.push(ch);
            }else if(ch == '('){
                symS.push(ch);
                if(i+1 < n && s.charAt(i+1) == '-'){
                    numS.push(0);
                }
            }else if(ch == ')'){
                Deque<Integer> curNum = new LinkedList<>();
                Deque<Character> curSym = new LinkedList<>();
                while(!symS.isEmpty() && symS.peek() != '('){
                    curNum.push(numS.pop());
                    curSym.push(symS.pop());
                }
                curNum.push(numS.pop());
                while(!curSym.isEmpty()){
                    char symbol = curSym.poll();
                    int num1 = curNum.poll();
                    int num2 = curNum.poll();
                    if(symbol == '+'){
                        curNum.push(num1+num2);
                    }else if(symbol == '-'){
                        curNum.push(num1-num2);
                    }
                }
                numS.push(curNum.pop());
                symS.poll();
            }else{
                String cur = "";
                int j = i;
                if(j < n){
                    while(j < n && s.charAt(j) >= '0' && s.charAt(j) <= '9'){
                        cur+=s.charAt(j);
                        j++;
                    }
                }
                numS.push(Integer.parseInt(cur));
            }
        }
        while(!symS.isEmpty()){
           int num1 = numS.pollLast();
           int num2 = numS.pollLast();
           char symbol = symS.pollLast();
           if(symbol == '+'){
               numS.addLast(num1+num2);
           }else if(symbol == '-'){
               numS.addLast(num1-num2);
           }
        }
        return numS.peek();
    }
    @Test
    public void show(){
        String s = "1+5-4";
        System.out.println(calculate(s));
    }
}
