package qrxedu.leedcode22;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯求所有合理的括号组合
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int left = 0;
    public int right = 0;
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        dfs(list,s,n);
        return list;
    }
    public void dfs(List<String> list,StringBuilder s,int n){
        if(s.length() == n * 2){
            list.add(s.toString());
            return;
        }
        if(left < n){
            s.append('(');
            left++;
            dfs(list,s,n);
            left--;
            s.deleteCharAt(s.length()-1);
        }
        if(right < left){
            s.append(')');
            right++;
            dfs(list,s,n);
            right--;
            s.deleteCharAt(s.length()-1);
        }
    }
}
