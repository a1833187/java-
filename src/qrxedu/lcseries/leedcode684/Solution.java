package qrxedu.lcseries.leedcode684;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < n;i++){
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];
            if(find(parent,node1) != find(parent,node2)){
                union(parent,node1,node2);
            }else{
                return edge;
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int i, int j) {
        parent[find(parent,j)] = parent[find(parent,i)];
    }

    public int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent,parent[i]);
        }
        return parent[i];
    }

}
