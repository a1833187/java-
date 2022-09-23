package qrxedu.e101;

import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E74 {
    public int n;
    public ArrayList<String> restoreIpAddresses (String s) {
        // write code here
        ArrayList<String> l = new ArrayList<>();
        Set<String> set = new HashSet<>();
        n = s.length();
        if(n == 0){
            return l;
        }
        dfs(s,set,0,new StringBuilder(),0);
        for(String cur : set){
            l.add(cur);
        }
        return l;
    }
    public void dfs(String s, Set<String> l, int index, StringBuilder ss, int cnt){
        if(ss.length() == n + 3){
            if(cnt == 4){
                String cur = new String(ss);
                l.add(cur);
            }
            return;
        }
        if(cnt > 3){
            return;
        }
        for(int i = index; i < Math.min(index+3,n);i++){
            String ch;
            if(cnt < 3){
                ch = s.substring(index,i+1);
            }else{
                ch = s.substring(index,n);
            }

            if(isV(ch)){
                if(cnt < 3){
                    ch = ch + ".";
                }
                int len = ch.length();
                ss.append(ch);
                dfs(s,l,i+1,ss,cnt+1);
                ss.delete(ss.length()-len,ss.length());
            }
        }
    }
    public boolean isV(String s){
        int l = s.length();
        if(l > 3){
            return false;
        }
        if(l == 1){
            return true;
        }
        if(s.charAt(0) == '0'){
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
    @Test
    public void show(){
        String s = "25525522135";
        System.out.println(restoreIpAddresses(s));
    }
}
