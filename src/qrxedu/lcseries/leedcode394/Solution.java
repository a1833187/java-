package qrxedu.lcseries.leedcode394;

import java.util.Stack;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {

    public String decodeString(String s) {
        Stack<Integer> numS = new Stack();
        Stack<Character> numC = new Stack();
        int n = s.length();
        int r = 0;
        while(r < n){
            if(s.charAt(r) >= '0' && s.charAt(r) <= '9'){
                int l = r;
                while(r < n && s.charAt(r) >= '0' && s.charAt(r) <= '9'){
                    r++;
                }
                numS.push(Integer.parseInt(s.substring(l,r)));
            }else if(s.charAt(r) == ']'){
                StringBuilder cur = new StringBuilder();
                while(!numC.isEmpty() && numC.peek() != '['){
                    cur.append(numC.pop());
                }
                reverse(cur);
                numC.pop();
                int num = numS.pop();
                for(int i = 0; i < num; i++){
                    for(int j = 0; j < cur.length(); j++){
                        numC.push(cur.charAt(j));
                    }
                }
                r++;
            }else{
                numC.push(s.charAt(r));
                r++;
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!numC.isEmpty()){
            ans.append(numC.pop());
        }
        reverse(ans);
        return new String(ans);
    }
    public void reverse(StringBuilder s){
        int l = 0,r = s.length()-1;
        while(l < r){
            char ch = s.charAt(l);
            s.setCharAt(l,s.charAt(r));
            s.setCharAt(r,ch);
            l++;
            r--;
        }
    }

}
