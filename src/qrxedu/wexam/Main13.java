package qrxedu.wexam;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 不用算法运算符 返回A+B的结果
 * 位运算:在位运算中，异或能够表示两个数不进位相加，与能够表示两个数进位的相加，
 * 把这两个步骤重复进行直到 与运算得到的进位和为0，这样异或所得的到的结果就是两数相加的结果。
 * @author qiu
 * @version 1.8.0
 */
public class Main13 {
    public int addAB1(int A,int B){
        int XOR,AND;
        while(B != 0){
            XOR = A ^ B;
            AND = (A & B) << 1;
            A = XOR;
            B = AND;
        }
        return A;
    }
    public int addAB(int A, int B) {
       int[] a = transform(A);
       int[] b = transform(B);
       int[] c = new int[a.length];
       int[] res = new int[a.length];
       if(a[a.length-1] == 1 && b[a.length-1] == 1){
           c[a.length-1] = 1;
       }
       for(int i = a.length-1; i >= 1;i--){
           int count = 0;
           if(a[i] == 1){
               count++;
           }
           if(b[i] == 1){
               count++;
           }
           if(c[i] == 1){
               count++;
           }
           if(count == 0){
               res[i] = 0;
               c[i-1] = 0;
           }
           if(count == 1){
               res[i] = 1;
               c[i-1] = 0;
           }
           if(count == 2){
               res[i] = 0;
               c[i-1] = 1;
           }
           if(count == 3){
               res[i] = 1;
               c[i-1] = 1;
           }
           if(i == 1){
               res[i-1] = c[i-1];
           }
       }
       int ans = 0;
       for(int i = a.length-1;i>=0;i--){
           ans += res[i]*Math.pow(2,a.length-1-i);
       }
       return ans;
    }
    public int[] transform(int n){
        Stack<Integer> stack = new Stack<>();
        if(n == 0){
            stack.push(0);
        }
        while(n!=0){
            stack.push(n&1);
            n = n >> 1;
        }
        int[] arr = new int[stack.size()+1];
        int k = 1;
        while(!stack.empty()){
            arr[k++] = stack.pop();
        }
        return arr;
    }
    @Test
    public void show(){
        System.out.println(addAB(4,5));
    }
}
