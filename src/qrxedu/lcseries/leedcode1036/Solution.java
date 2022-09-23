package qrxedu.lcseries.leedcode1036;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author qiu
 * @version 1.8.0
 * 0表示通路，1表示不通道路，2表示可走道路
 */
public class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if(blocked.length<2){
            return true;
        }
        int row = (int) Math.pow(10, 4) + 2;
        int col = (int) Math.pow(10, 4) + 2;
        long[][] map = new long[row][col];
        //初始化迷宫
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[0][i] = 1;
            map[map.length - 1][i] = 1;
            map[i][map.length - 1] = 1;
        }
        for (int i = 0; i < blocked.length; i++) {
            if (blocked[i] != null) {
                map[blocked[i][0] + 1][blocked[i][1] + 1] = 1;
            }
        }
        return run(source[0] + 1, source[1] + 1, map, target);
    }

    public boolean run(int i, int j, long[][] map, int[] target) {
        if (i == target[0] + 1 && j == target[1] + 1) {
            return true;
        }
        map[i][j] = 2;
        if(map[i][j+1] == 0){
            run(i,j+1,map,target);
        }else if(map[i+1][j] == 0){
            run(i+1,j,map,target);
        }else if(map[i][j-1] == 0){
            run(i,j-1,map,target);
        }else if(map[i-1][j] == 0){
            run(i-1,j,map,target);
        }else{
            map[i][j] = 1;
            return false;
        }
        return true;
    }

    @Test
    public void show() {
   /*     int[][] bl = {{0,1},{1,0}};
        int[] so = {0, 0};
        int[] ta = {0, 2};
        System.out.println(isEscapePossible(bl, so, ta));*/
        long a = 131L+131;
        long b = 2*131L;
        Set<Long> set = new HashSet<>();
        set.add(a);
        System.out.println(set.contains(b));
    }

    /**
     * BFS+有限的障碍物面积
     * BFS通常用队列实现
     */
    int EDGE = (int)1e6;
    int MAX = (int)1e5;
    /**
     * BASE 是哈希值，用于表示一个点的横纵坐标是否被访问过
     * 每个点的哈希值：x*BASE+y
     */
    long BASE = 131L;
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    Set<Long> set = new HashSet<>();
    public boolean isEscape(int[][] blocked,int[] s,int[] t){
        int n = blocked.length;
        for(int[] i:blocked){
            set.add(i[0]*BASE+i[1]);
        }
        MAX = n*(n-1)/2;
        return check(s,t)&&check(t,s);
    }
    public boolean check(int[] s, int[] t){
        Set<Long> vis = new HashSet<>();
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(s);
        while(!queue.isEmpty()&&vis.size()<=MAX){
            int[] xy = queue.pollFirst();
            int x = xy[0];
            int y = xy[1];
            if(x == t[0] && y == t[1]){
                return true;
            }
            for(int[] d:dir){
                int nx = x + d[0];
                int ny = y + d[1];
                if(nx<0||nx>=EDGE||ny<0||ny>=EDGE){
                    continue;
                }
                long hash = nx * BASE + ny;
                if(set.contains(hash)){
                    continue;
                }
                if(vis.contains(hash)){
                    continue;
                }
                vis.add(hash);
                queue.addLast(new int[]{nx,ny});
            }
        }
        return vis.size()>MAX;
    }
}
