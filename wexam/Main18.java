package qrxedu.wexam;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main18 {
    public int binInsert(int n, int m, int j, int i) {
        // write code here
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while(n != 0){
            s1.push(n & 1);
            n = n >> 1;
        }
        while(m != 0){
            s2.push(m & 1);
            m = m >> 1;
        }
        while(!s1.empty()){
            sb1.append(s1.pop());
        }
        while(!s2.empty()){
            sb2.append(s2.pop());
        }
        for(int k = sb2.length()-1; k >= 0; k--){
            int start = sb1.length()-sb2.length()+k-j;
            sb1.replace(start,start+1,sb2.substring(k,k+1));
        }
        int ans = 0;
        for(int k = 0; k < sb1.length(); k++){
            ans = ans * 2 + Integer.parseInt(sb1.substring(k,k+1));
        }
        return ans;
    }
    @Test
    public void show(){
        System.out.println(binInsert(1024,19,2,6));
    }
}
