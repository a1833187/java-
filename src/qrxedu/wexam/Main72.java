package qrxedu.wexam;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main72 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            String[] arr = new String[n];
            for(int i = 0; i < n; i++){
                arr[i] = scanner.next();
            }
            Deque<Integer> numD = new LinkedList<>();
            for(String num : arr){
                if(!isY(num)){
                    numD.push(Integer.parseInt(num));
                }else{
                    int a = 0, b = 0;
                    if(!numD.isEmpty()){
                        a = numD.pop();
                    }
                    if(!numD.isEmpty()){
                        b = numD.pop();
                    }
                    int cur = getRes(b,a,num);
                    numD.push(cur);
                }
            }
            System.out.println(numD.peek());
        }
    }
    public static boolean isY(String ch){
        return "+".equals(ch) ||"-".equals(ch) || "*".equals(ch) || "/".equals(ch);
    }
    public static int getRes(int a,int b,String ch){
        if("+".equals(ch)){
            return a + b;
        }
        if("-".equals(ch)){
            return a - b;
        }
        if("*".equals(ch)){
            return a * b;
        }
        if("/".equals(ch)){
            return a / b;
        }
        return 0;
    }
}
