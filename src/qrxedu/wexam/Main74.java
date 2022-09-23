package qrxedu.wexam;

import java.text.BreakIterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main74 {
    public static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] map = new char[10][10];
        while(scanner.hasNext()){
            for(int i = 0; i < 10; i++){
                String str = scanner.next();
                for(int j = 0; j < 10; j++){
                    map[i][j] = str.charAt(j);
                }
            }
            boolean flag = false;
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] isVisited = new boolean[10][10];
            queue.offer(new int[]{0,1});
            isVisited[0][1] = true;
            int step = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                while(size != 0) {
                    int[] cur = queue.poll();
                    int x = cur[0], y = cur[1];
                    isVisited[x][y] = true;
                    if (x == 9 && y == 8) {
                        flag = true;
                        break;
                    }
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dir[i][0];
                        int ny = y + dir[i][1];
                        if (nx < 0 || nx >= 10 || ny < 0 || ny >= 10
                                || isVisited[nx][ny] || map[nx][ny] == '#') {
                            continue;
                        }
                        queue.offer(new int[]{nx, ny});
                    }
                    size--;
                }
                if(flag){
                    break;
                }
                step++;
            }
            System.out.println(step);
        }
    }
}
