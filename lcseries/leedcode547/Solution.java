package qrxedu.leedcode547;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> list = new ArrayList<>();
        boolean flag = false;
        int n = isConnected.length;
        for(int i = 0; i < n; i++){
            for(int j = 0;j < n;j++){
                List<Integer> l = new ArrayList<>();
                if(j > i &&isConnected[i][j] == 1){
                    l.add(i+1);
                    l.add(j+1);
                    list.add(l);
                }
                if(j != i && isConnected[i][j] == 1){
                    flag = true;
                }
            }
            if(!flag){
                List<Integer> ll = new ArrayList<>();
                ll.add(i+1);
                ll.add(i+1);
                list.add(ll);
            }
        }
        int[] parent = new int[n+1];
        for(int i = 1; i <= n;i++){
            parent[i] = i;
        }
        for(int i = 0; i < list.size();i++){
            int i1 = list.get(i).get(0);
            int i2 = list.get(i).get(1);
            if(find(parent,i1) != find(parent,i2)){
                union(parent,i1,i2);
            }
        }
           int count = 0;
            for(int i = 1; i < parent.length;i++){
                if(parent[i]  == i){
                    count++;
                }
            }
            return count;
    }
    public int find(int[] parent,int index){
        if(parent[index] != index){
            parent[index] = find(parent,parent[index]);
        }
        return parent[index];
    }
    public void union(int[] parent,int i1,int i2){
        parent[find(parent,i1)] = parent[find(parent,i2)];
    }
    @Test
    public void show(){
        int[][] num = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        int[][] num1 = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(num));
    }
}
