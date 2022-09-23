package qrxedu.e101;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E60 {
    public int n1;
    public int n;
    public ArrayList<String> generateParenthesis (int _n) {
        // write code here
        Set<String> set = new HashSet<>();
        ArrayList<String> res = new ArrayList<>();
        n1 = _n;
        n = 2 * _n;
        String s = "";
        dfs(0,set,0,s,'(');
        for(String sa : set){
            res.add(sa);
        }
        return res;
    }
    public void dfs(int index,Set<String> res,int cnt,String s,char ch){
        //写的有点啰嗦
        if(index == n){
            if(cnt == 0){
                res.add(s);
                s = "";
            }
            return;
        }
        s+=ch;
        if(ch == '('){
            cnt++;
        }else{
            cnt--;
        }
        if(cnt < 0){
            return;
        }
        dfs(index+1,res,cnt,s,'(');
        dfs(index+1,res,cnt,s,')');
    }
    public void dfs1(int l,int r,String s,ArrayList<String> res){
        //正解
        if(l == n1 && r == n1){
            res.add(s);
            return;
        }
        if(l < n1){
            dfs1(l+1,r,s+'(',res);
        }
        if(r < n1 && r < l){
            dfs1(l,r+1,s+')',res);
        }
    }
    @Test
    public void show(){
        System.out.println(generateParenthesis(1));
    }
}
