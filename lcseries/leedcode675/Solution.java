package qrxedu.leedcode675;

import java.util.*;

/**
 * 为高尔夫比赛砍树: 按照树从低到高砍树,求砍完所有树的最小步数.
 * 理解题意的时候可以代入场景.
 * 从低到高砍树,是说砍树的顺序,不意味着当前格必须向四周比当前格更高的位置走.
 * 多源bfs
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Solution {
    List<List<Integer>> f;
    int m,n;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int cutOffTree(List<List<Integer>> forest) {
        f = forest;
        m = forest.size();
        n = forest.get(0).size();
        List<int[]> tree = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int t = forest.get(i).get(j);
                if(t > 1){
                    tree.add(new int[]{i,j});
                }
            }
        }
        Collections.sort(tree, (o1, o2) -> forest.get(o1[0]).get(o1[1]) - forest.get(o2[0]).get(o2[1]));
        int sx = 0,sy = 0;
        int ans = 0;
        for(int i = 0; i < tree.size(); i++){
            int[] t = tree.get(i);
            int ex = t[0],ey = t[1];
            int step = bfs(sx,sy,ex,ey);
            if(step == -1){
                return -1;
            }
            ans += step;
            sx = ex;
            sy = ey;
        }
        return ans;
    }
    public int bfs(int sx,int sy,int ex, int ey){
        if(sx == ex &&sy == ey){
            return 0;
        }
        boolean[][] isVisited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int step = 0;
        queue.offer(new int[]{sx,sy});
        isVisited[sx][sy] = true;
        while(!queue.isEmpty()){
            step++;
            int size = queue.size();
            while(size != 0){
                int[] cur = queue.poll();
                int cx = cur[0],cy = cur[1];
                for(int i = 0; i < 4; i++){
                    int nx = cx + dir[i][0];
                    int ny = cy + dir[i][1];
                    if(nx < 0 || nx >= m || ny < 0 || ny >= n
                    || isVisited[nx][ny] || f.get(nx).get(ny) <= 0){
                        continue;
                    }
                    isVisited[nx][ny] = true;
                    if(nx == ex && ny == ey){
                        return step;
                    }
                    queue.offer(new int[]{nx,ny});
                }
                size--;
            }
        }
        return -1;
    }
}
