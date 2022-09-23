package qrxedu.e101;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E58 {
    int n;
    public ArrayList<String> Permutation (String str) {
        // write code here
        n = str.length();
        Set<String> set = new HashSet<>();
        ArrayList<String> res = new ArrayList<>();
        dfs(str.toCharArray(),0,set);
        for(String s : set){
            res.add(s);
        }
        return res;
    }
    public void dfs(char[] arr,int index,Set<String> set){
        if(index == n){
            String curS = new String(arr);
            set.add(curS);
            return;
        }
        for(int i = index; i < n; i++){
            swap(arr,i,index);
            dfs(arr,index+1,set);
            swap(arr,i,index);
        }
    }
    private void swap(char[] arr,int i,int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
