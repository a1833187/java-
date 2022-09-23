package qrxedu.lcseries.leedcode417;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断每个点能否到达边界不好判断,因为一个点移动的条件是该点高度大于等于四周相邻的点.如果该点和周围一个点的高度相等,则会陷入循环状态.
 * 所以反向搜索从边界是否能到达某个点.从边界开始搜索刚开始的条件是已知的,即边界的点一定能到达某个洋.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    int m;
    int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        //1表示左边界和上边界,2表示下边界和右边界
        boolean[][] isValid1 = new boolean[m][n];
        boolean[][] isValid2 = new boolean[m][n];
        for(int i = 0; i < m;i++){
            dfs(isValid1,heights,i,0);
        }
        for(int i = 0; i < n; i++){
            dfs(isValid1,heights,0,i);
        }
        for(int i = 0; i < m; i++){
            dfs(isValid2,heights,i,n-1);
        }
        for(int i = 0; i < n; i++){
            dfs(isValid2,heights,m-1,i);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isValid1[i][j] && isValid2[i][j]){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(i);
                    cur.add(j);
                    list.add(cur);
                }
            }
        }
        return list;
    }
    public void dfs(boolean[][] isValid,int[][] heights,int x,int y){
       if(isValid[x][y]){
           return;
       }
       isValid[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx < m && nx >= 0 && ny >= 0 && ny < n && heights[nx][ny] >= heights[x][y]){
                dfs(isValid,heights,nx,ny);
            }
        }
    }
}
