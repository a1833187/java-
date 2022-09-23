package qrxedu.e101;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E56 {
    int n;
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        n = num.length;
        Arrays.sort(num);
        Set<String> ans = new TreeSet<>();
        //这得传入一个有序且可以去重的数据结构:TreeSet
        dfs(num,0,ans);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(String s : ans){
            String[] ss = s.split(" ");
            ArrayList<Integer> curL = new ArrayList<>();
            for(int i = 0; i < n; i++){
                curL.add(Integer.parseInt(ss[i]));
            }
            res.add(curL);
        }
        return res;
    }
    private void dfs(int[] num,int index,Set<String> ans){
        if(index == n){
            String s = "";
            for(int i = 0; i < n; i++){
                if(i != n-1){
                    s += num[i] + " ";
                }else{
                    s += num[i] + "";
                }
            }
            ans.add(s);
            return;
        }
        for(int i = index; i < n; i++){
            swap(num,i,index);
            dfs(num,index+1,ans);
            swap(num,i,index);
        }
    }
    private void swap(int[] num,int i,int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
