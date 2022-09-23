package qrxedu.wexam;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        int n = scanner.nextInt();
            Stack<Long> stack = new Stack<>();
            StringBuffer sb = new StringBuffer();
            while(m/n>=1){
                long k = m % n;
                stack.push(k);
                m = m / n;
            }
            stack.push(m);
            while(!stack.empty()){
                if(stack.peek() < 10){
                    sb.append(stack.pop());
                }else{
                    sb.append((char)((stack.pop()-10)+'A'));
                }
            }
            System.out.println(sb.toString());

    }
}
