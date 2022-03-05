package qrxedu.leedcode207;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程表问题：典型的拓扑排序
 * 在上a课之前必须先上b课，问是否能够上完所有课
 * 关键：
 * 1.如何去模拟这张图？以每部分课的共同先修课程为基础建立不同的先修课程的树形结构
 * 2.如何去定义每个节点的状态？搜索中(搜索过程中结束了。。)：1；未搜索：0；已搜索：2 ！！！
 *
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean flag = true;
    public int[] visited;
    public List<List<Integer>> list;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        list = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length;i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i = 0; i < numCourses && flag;i++){
            if(visited[i] == 0){
                dfs(i);
            }
        }
        return flag;
    }
    public void dfs(int i){
        visited[i] = 1;
        for(int u : list.get(i)){
            if(visited[u] == 0){
                dfs(u);
            }else if(visited[u] == 1){
                flag = false;
                return;
            }
        }
        visited[i] = 2;
    }

}
