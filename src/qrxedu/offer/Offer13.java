package qrxedu.offer;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer13 {
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    boolean[][] isV;
    static class Pair{
        int x;
        int y;
        int step;
    }
    public int movingCount(int m, int n, int k) {
        int ans = 0;
        if(k == 0){
            return 1;
        }
        isV = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        Pair pair = new Pair();
        pair.x = 0;
        pair.y = 0;
        pair.step = 0;
        q.offer(pair);
        while(!q.isEmpty()){
            Pair cur = q.poll();
            if(cur.step <= k){
                ans++;
            }else{
                continue;
            }
            isV[cur.x][cur.y] = true;
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dir[i][0];
                int ny = cur.y + dir[i][1];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n || isV[nx][ny]){
                    continue;
                }
                isV[nx][ny] = true;
                Pair tmp = new Pair();
                tmp.x = nx;
                tmp.y = ny;
                tmp.step = getStep(nx,ny);
                q.offer(tmp);
            }
        }
        return ans;
    }
    public int getStep(int x,int y){
        int ans = 0;
        while(x != 0){
            ans += x % 10;
            x /= 10;
        }
        while(y != 0){
            ans += y %10;
            y /= 10;
        }
        return ans;
    }
    @Test
    public void show(){
        System.out.println(movingCount(11,8,16));
    }
}
