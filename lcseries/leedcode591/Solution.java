package qrxedu.leedcode591;

import java.util.Stack;

/**
 * 字符串模拟:太恶心了吧.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isValid(String code) {
        String cl = "<![CDATA[";
        String ce = "]]>";
        int n = code.length();
        int l = 0;
        Stack<String> s = new Stack<>();
        while(l < n){
            char ch = code.charAt(l);
                if(l + 8 < n && cl.equals(code.substring(l,l+9))){
                    int r = l + 9;
                    boolean o = false;
                    while(r < n && !o){
                        if(r + 2 < n && ce.equals(code.substring(r,r+3))){
                            r = r + 3;
                            o = true;
                        }else{
                            r++;
                        }
                    }
                    if(!o){
                        return false;
                    }
                    l = r;
                }else if(ch == '<'){
                    if(l == n-1){
                        return false;
                    }
                    boolean end = code.charAt(l + 1) == '/';
                    int p = end ? l + 2:l+1, j = p;
                    while(j < n && code.charAt(j) != '>'){
                        if(!Character.isUpperCase(code.charAt(j))){
                            return false;
                        }
                        j++;
                    }
                    String cur = code.substring(p,j);
                    if(cur.length()<1 || cur.length() > 9){
                        return false;
                    }
                    l = j+1;
                    if(end){
                        if(s.size() == 0 || !s.pop().equals(cur)){
                            return false;
                        }
                        //这里强调的是当最外层标签匹配结束以后,如果还有未扫描到的字符,则返回false
                        if(s.size() == 0 && l < n){
                            return false;
                        }
                    }else {
                        s.push(cur);
                    }
                }else{
                    if(l == 0){
                        return false;
                    }
                    l++;
                }
        }
        return s.size() == 0;
    }
}
