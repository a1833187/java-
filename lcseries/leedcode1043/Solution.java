package com.qrxedu.lcseries.leedcode1043;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[][] draw(int[][] grid, int row, int col, int color) {
        int myColor = grid[row][col];
        List<int[]> border = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        isVisited[row][col] = true;
        bfs(grid, row, col, myColor, border, isVisited);
        for (int i = 0; i < border.size(); i++) {
            int x = border.get(i)[0];
            int y = border.get(i)[1];
            grid[x][y] = color;
        }
        /* dfs1(grid,row,col,myColor,border,isVisited,color);*/
        return grid;
    }

    /**
     * 深度搜索
     * 存放边界染色点
     *
     * @param grid      给定网格
     * @param x         移动坐标的横
     * @param y         移动坐标的纵
     * @param myColor   初始坐标的颜色
     * @param border    存放符合条件的边界点
     * @param isVisited 表示网格中的某个点是否被访问过!!
     */
    public void dfs(int[][] grid, int x, int y, int myColor, List<int[]> border, boolean[][] isVisited) {
        int m = grid.length;
        int n = grid[0].length;
        boolean isBorder = false;
        //每个点的四个相邻点
        int[][] direc = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < 4; i++) {
            int nx = direc[i][0] + x;
            int ny = direc[i][1] + y;
            if (!(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == myColor)) {
                isBorder = true;
            } else if (!isVisited[nx][ny]) {
                isVisited[nx][ny] = true;
                dfs(grid, nx, ny, myColor, border, isVisited);
            }
        }
        if (isBorder) {
            border.add(new int[]{x, y});
        }
    }

    /**
     * 深度搜索
     * 直接染色
     */
    public void dfs1(int[][] grid, int x, int y, int myColor, List<int[]> border, boolean[][] isVisited, int color) {
        int m = grid.length;
        int n = grid[0].length;
        boolean isBorder = false;
        int[][] direc = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        isVisited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = direc[i][0] + x;
            int ny = direc[i][1] + y;
            if (!(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == myColor)) {
                isBorder = true;
            } else if (!isVisited[nx][ny]) {
                isVisited[nx][ny] = true;
                dfs1(grid, nx, ny, myColor, border, isVisited, color);
            }
        }
        if(isBorder) {
            grid[x][y] = color;
        }
    }

    public void bfs(int[][] grid, int x, int y, int myColor, List<int[]> boarder, boolean[][] isVisited) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{x, y});
        int[][] direc = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        boolean isBoarder = false;
        isVisited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            //这里因为x和y不再进行递归，所以需要手动重置
            x =tmp[0];
            y = tmp[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + direc[i][0];
                int ny = y + direc[i][1];
                if (!(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == myColor)){
                    isBoarder = true;
                }else if(!isVisited[nx][ny]){
                    isVisited[nx][ny] = true;
                    //将这个点周围满足条件的
                    queue.addLast(new int[]{nx,ny});
                }
            }
            //循环结束以后在判断这个点是不是边界点
            //因为边界点满足的条件是四个相邻点中至少有一个其他边界的点
            //如果一个点的四个相邻点都是改边界的点，则isBoarder为false,该点不会被记录
            if(isBoarder){
                boarder.add(tmp);
            }
        }
    }
}
