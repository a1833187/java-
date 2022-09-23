package qrxedu.lcseries.leedcode592;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String fractionAddition(String expression) {
        int n = 3628800;
        List<Integer> list = new ArrayList<>();
        int k1 = 0;
        int k2 = 0;
        int k3 = 0;
        int i = 0;
        while(i < expression.length()){
            if(expression.charAt(i) == '-' || expression.charAt(i) == '+'){
                k1 = i;
            }
            while(i < expression.length() && expression.charAt(i) != '/'){
                i++;
            }
            k2 = i;
            while(i < expression.length() && !(expression.charAt(i) == '-' || expression.charAt(i) == '+')){
                i++;
            }
            k3 = i;
            int num1 = Integer.parseInt(expression.substring(k1,k2));
            int num2 = Integer.parseInt(expression.substring(k2+1,k3));
            list.add(num1 * n / num2);
        }
        int sum = 0;
        for(int num : list){
            sum+= num;
        }
        int sum1 = sum > 0 ? sum : sum * -1;
        int cu = func(sum1,n);
        if(cu == 0){
            return "" + 0 + "/" + "" + 1;
        }else{
            return "" + sum/cu + "/" + "" + n/cu;
        }
    }
    // 48 18
    public int func(int n1,int n2){
        if(n1 == 0 || n2 == 0){
            return 0;
        }
        if(n1 < n2){
            int tmp = n1;
            n1 = n2;
            n2 = tmp;
        }
        int r = n1 % n2;
        while(r != 0){
            n1 = n2;
            n2 = r;
            r = n1 % n2;
        }
        return n2;
    }
    @Test
    public void show(){
        String expression = "1/3-1/2";
        System.out.println(fractionAddition(expression));
    }
}
