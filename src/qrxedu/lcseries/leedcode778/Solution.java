package qrxedu.lcseries.leedcode778;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    int[][] g;
    int n;
    int[] p;
    public int swimInWater(int[][] grid) {
        g = grid;
        n = g.length;
        p = new int[n*n];
        for(int i = 0; i < p.length; i++){
            p[i] = i;
        }
       List<int[]> pairs = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int idx = getId(i,j);
                p[idx] = idx;
                if(i + 1 < n){
                    int a = idx,b = getId(i+1,j);
                    int w = Math.max(grid[i][j],grid[i+1][j]);
                    pairs.add(new int[]{a,b,w});
                }
                if(j + 1 < n){
                    int a = idx,b = getId(i,j+1);
                    int w = Math.max(grid[i][j],grid[i][j+1]);
                    pairs.add(new int[]{a,b,w});
                }
            }
        }
        int start = getId(0,0);
        int end = getId(n-1,n-1);
        Collections.sort(pairs, (o1, o2) -> o1[2] - o2[2]);
        for(int[] arr : pairs){
            int a = arr[0],b = arr[1],w = arr[2];
            union(a,b);
            if(query(start,end)){
                return w;
            }
        }
        return -1;
    }
    public int find(int x){
        if(x != p[x]){
            p[x] = find(p[x]);
        }
        return p[x];
    }
    public boolean query(int a,int b){
        return find(a) == find(b);
    }
    public void union(int a,int b){
        p[find(a)] = p[find(b)];
    }
    public int getId(int x,int y){
        return x * n + y;
    }
}
