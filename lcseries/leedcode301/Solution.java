package qrxedu.lcseries.leedcode301;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 回溯
 * 首先判断要删除的最少左括号和右括号的个数
 * 然后回溯:是左括号(删or不删),是右括号(删or不删)
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        List<String> l = new ArrayList<>();
        int left = 0;
        int right = 0;
        int delCnt = 0;
        int delLeftCnt = 0;
        int delRightCnt = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                left++;
            }else if(ch ==')'){
                right++;
            }else{
                continue;
            }
            if(right > left){
                right--;
                delRightCnt++;
            }
        }
        while(left > right){
            left--;
            delLeftCnt++;
        }
//        if(left == 0 || right == 0){
//            return l;
//        }
        if(delLeftCnt == 0 && delRightCnt == 0){
            l.add(s);
            return l;
        }
        StringBuilder ss = new StringBuilder(s);
        dfs(ss,0,delLeftCnt,delRightCnt);
        for(String cur : set){
            l.add(cur);
        }
        return l;

    }
    private void dfs(StringBuilder s,int index,int leftCnt,int rightCnt){
        if(index == s.length()){
            if(leftCnt == 0 && rightCnt == 0){
                String cur = new String(s);
                if(isValid(cur)) {
                    set.add(cur);
                }
            }
            return;
        }
        if(leftCnt == 0 && rightCnt == 0){
            String cur = new String(s);
            if(isValid(cur)) {
                set.add(cur);
            }
        }
        char ch = s.charAt(index);

        if(ch == '('){
            // 1.删掉这个地方的左括号
            if(leftCnt > 0){
                s.deleteCharAt(index);
                dfs(s,index,leftCnt-1,rightCnt);
                s.insert(index,ch);
            }
            dfs(s,index+1,leftCnt,rightCnt);
            // 2.对该左括号不作处理
        }else if(ch == ')'){
            if(rightCnt > 0){
                s.deleteCharAt(index);
                dfs(s,index,leftCnt,rightCnt-1);
                s.insert(index,ch);
            }
            dfs(s,index+1,leftCnt,rightCnt);
        }else{
            dfs(s,index+1,leftCnt,rightCnt);
        }

    }
    private boolean isValid(String s){
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                cnt++;
            }else if(s.charAt(i) == ')'){
                cnt--;
            }
            if(cnt < 0){
                return false;
            }
        }
        return cnt == 0;
    }

    /**
     * 这道题也可以用广搜来做
     * 因为要删除是最小的括号,所以利用bfs枚举所有情况
     */
    public List<String> removeInvalidParentheses1(String s) {
        List<String> ans = new ArrayList<String>();
        Set<String> currSet = new HashSet<String>();

        currSet.add(s);
        while (true) {
            for (String str : currSet) {
                if (isValid(str)) {
                    ans.add(str);
                }
            }
            // 如果某轮ans中不为空,说明该轮就是最少的括号删除个数对应的合法字符串
            if (ans.size() > 0) {
                return ans;
            }
            Set<String> nextSet = new HashSet<String>();
            // 每次从现有str基础上删除一个括号,将所有情况枚举到nextSet中.
            for (String str : currSet) {
                for (int i = 0; i < str.length(); i ++) {
                    if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                        continue;
                    }
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        nextSet.add(str.substring(0, i) + str.substring(i + 1));
                    }
                }
            }
            currSet = nextSet;
        }
    }
    @Test
    public void show(){
        String s = "x(";
        System.out.println(removeInvalidParentheses(s));
    }
}
