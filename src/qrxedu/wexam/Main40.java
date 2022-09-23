package qrxedu.wexam;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main40 {
    static class Path{
        List<int[]> list;
        int x;
        int y;
    }
    static int[][] dict = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] maze = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                maze[i][j] = scanner.nextInt();
            }
        }
        boolean[][] isVisited = new boolean[m][n];
        Queue<Path> queue = new LinkedList<>();
        Path p = new Path();
        p.x = 0;
        p.y = 0;
        p.list = new ArrayList<>();
        p.list.add(new int[]{p.x,p.y});
        queue.offer(p);
        boolean flag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0) {
                Path p1 = queue.peek();
                isVisited[p1.x][p1.y] = true;
                if (p1.x == m - 1 && p1.y == n - 1) {
                    flag = true;
                    break;
                }
                for (int i = 0; i < 4; i++){
                    int nx = p1.x+dict[i][0];
                    int ny = p1.y+dict[i][1];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0 && !isVisited[nx][ny]){
                        isVisited[nx][ny] = true;
                        Path cur = new Path();
                        cur.x = nx;
                        cur.y = ny;
                        cur.list = new ArrayList<>(p1.list);
                        cur.list.add(new int[]{nx,ny});
                        queue.offer(cur);
                    }
                }
                queue.poll();
                size--;
            }
            if(flag){
                break;
            }
        }
        List<int[]> ans = queue.peek().list;
        for(int i = 0; i < ans.size();i++){
            System.out.println("("+ans.get(i)[0]+","+ans.get(i)[1]+")");
        }
    }
}

