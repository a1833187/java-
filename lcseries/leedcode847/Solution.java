package qrxedu.leedcode847;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 利用bfs去寻找最短路径时,最先找到的一定是最短的,不需要另外再加什么判断
 * 当一个搜索的题中可以走重边但也需要控制节点的访问情况是可以用
 * isVisited[v][mask]来表示,v表示当前节点,mask表示走都当前节点前所经历的情况:这个情况在
 * 本题中就是所有节点的访问情况,用二进制状态压缩成一个数(1<<n),1表示访问过,0表示没访问过.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int shortestPathLength(int[][] graph) {
       Queue<int[]> queue = new LinkedList<>();
       int n = graph.length;
       boolean[][] isVisited = new boolean[n][1<<n];
       int ans = 0;
       for(int i = 0; i < n; i++){
           queue.offer(new int[]{i,1<<i,0});
           isVisited[i][1<<i] = true;
       }
       while(!queue.isEmpty()){
           int[] cur = queue.poll();
           int v = cur[0], mask = cur[1],step = cur[2];
           if(mask == (1<<n)-1){
               ans = step;
               break;
           }
           for(int v1:graph[v]){
               int maskV = mask | (1<<v1);
               if(!isVisited[v1][maskV]){
                   queue.offer(new int[]{v1,maskV,step+1});
                   isVisited[v1][maskV] = true;
               }
           }
       }
       return ans;
    }

}
