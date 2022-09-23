package qrxedu.lcseries.leedcode1021;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String removeOuterParentheses(String s) {
        int l = 0,r = 1;
        int n = s.length();
        StringBuilder cur = new StringBuilder();
        int cnt = 1;
        while(r < n){
           if(s.charAt(r) == '('){
                cnt++;
            }else if(s.charAt(r) == ')'){
                cnt--;
            }
            if(cnt == 0){
                cur.append(s, l+1, r);
                r++;
                l = r;
            }else{
                r++;
            }
        }
        return new String(cur);
    }
    @Test
    public void show(){
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }
}
