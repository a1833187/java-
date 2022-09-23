package qrxedu.lcseries.leedcode678;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 有关括号的题目不是用到栈就是用到区间dp:f[i][j]表示从i-j的范围内....
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    private boolean flag;
    public boolean checkValidString(String s){
        Deque<Integer> leftS = new LinkedList<>();
        Deque<Integer> xS = new LinkedList<>();
        int n = s.length();
        if(n == 0){
            return true;
        }
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                leftS.push(i);
            }else if(ch == '*'){
                xS.push(i);
            }else{
                if(!leftS.isEmpty()){
                    leftS.pop();
                }else if(!xS.isEmpty()){
                    xS.pop();
                }else{
                    return false;
                }
            }
        }
        while(!leftS.isEmpty() && !xS.isEmpty()){
            int left = leftS.pop();
            int x = xS.pop();
            if(left > x){
                return false;
            }
        }
        return leftS.isEmpty();
    }
    public boolean checkValidString1(String s) {
        int n = s.length();
        int left = 0,right = 0;
        dfs(s,0,left,right);
        return flag;
    }
    private void dfs(String s,int index,int left,int right){
        if(index == s.length()){
            if(left == right){
                flag = true;
            }
            return;
        }
        if(flag){
            return;
        }
        if(left < right){
            return;
        }
        char ch = s.charAt(index);
        if(ch == '('){
            dfs(s,index+1,left+1,right);
        }else if(ch == ')'){
            dfs(s,index+1,left,right+1);
        }else{
            dfs(s,index+1,left,right);
            dfs(s,index+1,left+1,right);
            dfs(s,index+1,left,right+1);
        }
    }
    @Test
    public void show(){
        System.out.println(checkValidString("()"));
    }
}
