package qrxedu.e101;

import java.util.ArrayList;
/**
 * @author qiu
 * @version 1.8.0
 */
public class E55 {
    int n;
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        n = num.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        dfs(num,0,ans);
        return ans;
    }
    private void dfs(int[] num,int index,ArrayList<ArrayList<Integer>> ans){
        if(index == n){
            ArrayList<Integer> l = new ArrayList<>();
            for(int i = 0; i < n; i++){
                l.add(num[i]);
            }
            ans.add(l);
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
