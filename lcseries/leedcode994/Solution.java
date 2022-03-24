package qrxedu.leedcode994;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        if(m == 0){
            return 0;
        }
        int n = grid[0].length;
        int count = 0;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            while(size != 0){
                int[] cur = q.poll();
                for(int i = 0; i < 4;i++){
                    int nx = cur[0] + dir[i][0];
                    int ny = cur[1] + dir[i][1];
                    if(nx>=0 && nx < m && ny >= 0 && ny < n &&grid[nx][ny] == 1){
                        flag = true;
                        grid[nx][ny] = 2;
                        q.offer(new int[]{nx,ny});
                    }
                }
                size--;
            }
            if(flag) {
                count++;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return count;
    }
}
