package qrxedu.lcseries.leedcode216;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    List<Integer> list;
    boolean[] isVisited = new boolean[9];
    public List<List<Integer>> combinationSum3(int k, int n) {
        list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(1,res,k,n);
        return res;
    }
    public boolean isSame(List<Integer> l1,List<Integer> l2){
        for(int i = 0; i < l1.size();i++){
            if(!l1.get(i).equals(l2.get(i))){
                return false;
            }
        }
        return true;
    }
    public void dfs(int index,List<List<Integer>> res,int k,int n){
        if(k == 0){
            if(n == 0) {
                List<Integer> list1 = new ArrayList<>(list);
                Collections.sort(list1);
                for(int i = 0; i < res.size();i++){
                    List<Integer> cur = res.get(i);
                    if(isSame(cur,list1)){
                        return;
                    }
                }
                res.add(list1);
            }
            return;
        }
        for(int i = index;i<=9;i++){
            if(!isVisited[i-1]){
                isVisited[i-1] = true;
                k--;
                n-=i;
                list.add(i);
                dfs(index,res,k,n);
                list.remove(list.size()-1);
                k++;
                n+=i;
                isVisited[i-1] = false;
            }
        }
    }
    @Test
    public void show(){
        System.out.println(combinationSum3(3,7));
    }
}
