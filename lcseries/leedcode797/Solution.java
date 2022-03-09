package qrxedu.leedcode797;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    List<Integer> list;
    boolean[] isVisited;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int len = graph.length;
        isVisited = new boolean[len];
        list.add(0);
        isVisited[0] = true;
        dfs(graph,res,0);
        return res;
    }
    public void dfs(int[][] graph,List<List<Integer>> res,int i){
        if(i == graph.length -1){
            List<Integer> list1 = new ArrayList<>(list);
            res.add(list1);
            return;
        }
        for(int k = 0; k < graph[i].length;k++){
            if(!isVisited[graph[i][k]]){
                isVisited[graph[i][k]] = true;
                list.add(graph[i][k]);
                dfs(graph,res,graph[i][k]);
                isVisited[graph[i][k]] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
