package qrxedu.wexam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main65 {
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static boolean[][] isVisited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            isVisited = new boolean[m][n];
            char[][] map = new char[m][n];
            int x0 = 0, y0 = 0;
            for(int i = 0; i < m; i++){
                String s = scanner.next();
                for(int j = 0; j < n; j++){
                    map[i][j] = s.charAt(j);
                    if(map[i][j] == '@'){
                        x0 = i;
                        y0 = j;
                    }
                }
            }
            Queue<int[]> queue = new LinkedList<>();
            int[] ori = {x0,y0};
            queue.offer(ori);
            int cnt = 0;
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                cnt++;
                x0 = cur[0];
                y0 = cur[1];
                isVisited[x0][y0] = true;
                for(int i = 0; i < 4; i++){
                    int x = x0 + dir[i][0];
                    int y = y0 + dir[i][1];
                    if(x < 0 || x >= m || y < 0 || y >= n || isVisited[x][y] || map[x][y] != '.'){
                        continue;
                    }
                    isVisited[x][y] = true;
                    int[] tmp = {x,y};
                    queue.offer(tmp);
                }
            }
            System.out.println(cnt);
        }
    }
}
