package qrxedu.leedcode51;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 统计N皇后的所有排列的形式
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        int[] arr = new int[n];
        res = new ArrayList<>();
        char[][] s = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                s[i][j] = '.';
            }
        }
        dfs(0,s);
        return res;

    }
    public void dfs(int index,char[][] s){
        if(index == s.length){
            List<String> list = new ArrayList<>();
            for(char[] ch : s){
                list.add(new String(ch));
            }
            res.add(list);
            return;
        }

        for(int i = 0; i < s[0].length;i++){
            s[index][i] = 'Q';
            if(isTrue(s,index,i)){
                dfs(index+1,s);
            }
            s[index][i] = '.';
        }

    }

    public boolean isTrue(char[][] s,int x,int y){
        for(int i = 0; i < x;i++){
            for(int j = 0; j < s[0].length;j++){
                if(s[i][j] == 'Q' && (j == y || Math.abs(j-y) == Math.abs(i-x))){
                    return false;
                }
            }
        }
        return true;
    }
    @Test
    public void show(){
        System.out.println(solveNQueens(1));
    }
}
