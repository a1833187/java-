package qrxedu.lcseries.leedcode52;

/**
 * 统计N皇后的排列数量
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int count = 0;
    public int totalNQueens(int n){
        int[] arr = new int[n];
        dfs(arr,0);
        return count;
    }
    public void dfs(int[] arr,int index){
        if(index == arr.length){
            count++;
            return;
        }
        for(int i = 0; i < arr.length; i++){
            arr[index] = i;
            if(isValid(arr,index)){
                dfs(arr,index+1);
            }
        }
    }
    public boolean isValid(int[] arr,int x){
        for(int i = 0; i < x; i++){
            if(arr[i] == arr[x] || Math.abs(arr[i]-arr[x]) == Math.abs(i-x)){
                return false;
            }
        }
        return true;
    }
}
