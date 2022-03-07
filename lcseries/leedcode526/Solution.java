package qrxedu.leedcode526;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    int count = 0;
    List<List<Integer>> list;
    boolean[] v;

    /**
     * 第一种方法：列举出所有内容，然后判断。（超时了）
     * @param n
     * @return
     */
    public int countArrangement1(int n) {
        int[] arr = new int[n];
        for(int i = 0; i < n;i++){
            arr[i] = i+1;
        }
        countArr(arr,0);
        return count;
    }

    /**
     * 第二种方法：先把每个位置上所有可能的情况枚举出来然后dfs
     * @param n
     * @return
     */
    public int countArrangement(int n) {
        list = new ArrayList<>();
        v = new boolean[n];
        for(int i = 1; i <= n;i++){
            List<Integer> list1 = new ArrayList<>();
            for(int j = 1; j <= n; j++){
                if(i % j == 0 || j % i == 0){
                    list1.add(j);
                }
            }
            list.add(list1);
        }
        dfs(0,n);
        return count;
    }
    public void dfs(int index,int n){
        if(index == n){
            count++;
            return;
        }
        //注意这里回溯时是v[x-1]不是v[x]更不是v[index]
        for(int x:list.get(index)){
            if(!v[x-1]){
                v[x-1] = true;
                dfs(index+1,n);
                v[x-1] = false;
            }
        }
    }
    public void swap(int[] arr,int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public void countArr(int[] arr,int start){
        if(start == arr.length-1){
            if(isTrue(arr)){
                count++;
            }
            return;
        }
        for(int j = start; j < arr.length;j++){
            swap(arr,start,j);
            countArr(arr,start+1);
            swap(arr,start,j);
        }
    }
    public boolean isTrue(int[] arr){
        for(int i = 0; i < arr.length;i++){
            int min = Math.min(arr[i],i+1);
            int max = Math.max(arr[i],i+1);
            if(max % min != 0){
                return false;
            }
        }
        return true;
    }
    @Test
    public void show(){
        System.out.println(countArrangement(2));
    }
}
