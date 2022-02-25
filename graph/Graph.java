package com.qrxedu.graph;

import java.util.*;

/**
 * @author qiu
 * vertexList:点集
 * edges:邻接矩阵
 * countE:边数
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Graph {
    public List<String> vertexList;
    public int[][] edges;
    public int countE;
    public boolean[] isVisited;

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertEdges(0,2,1);
        graph.insertEdges(1,2,1);
        graph.insertEdges(0,3,1);
        graph.insertEdges(0,4,1);
        graph.showGraph();
        graph.initIsVisited(5);
        graph.dfs(graph.isVisited, 0);
        System.out.println();
        //必须初始化访问数组
        graph.initIsVisited(5);
        graph.bfs();
    }
    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        isVisited = new boolean[n];
    }
    public void initIsVisited(int n){
        isVisited = new boolean[n];
    }
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    public void insertEdges(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        countE ++;
    }
    public String getVertexByIndex(int v1){
        return vertexList.get(v1);
    }
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    public int numOfVertex(){
        return vertexList.size();
    }
    public int numOfEdges(){
        return countE;
    }
    public void showGraph(){
        for(int[] l:edges){
            //直接打印数组
            System.err.println(Arrays.toString(l));
        }
    }


    //dfs
    public int getFirstNeighbor(int index){
        for(int i = 0; i < vertexList.size();i++){
            if(edges[index][i] > 0){
                return i;
            }
        }
        return -1;
    }
    public int getNextNeighbor(int v1,int v2){
        for(int i = v2+1;i<vertexList.size();i++){
            if(edges[v1][i] > 0){
                return i;
            }
        }
        return -1;
    }
    private void dfs(boolean[] isVisited,int i){
        System.out.print(getVertexByIndex(i) + "->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1){
            if(!isVisited[w]){
                dfs(isVisited,w);
            }
            w = getNextNeighbor(i,w);
        }
    }
    public void dfs(){
        for(int i = 0; i < vertexList.size();i++){
            if(!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
        //也可以直接调用dfs(isVisited,0);
    }


    //bfs
    private void bfs(boolean[] isVisited,int i){
        Queue<Integer> queue = new LinkedList<>();
        System.out.print(getVertexByIndex(i) + "->");
        isVisited[i] = true;
        queue.offer(i);
        int u;
        int w;
        while(!queue.isEmpty()){
            u = queue.poll();
            w = getFirstNeighbor(u);
            while(w != -1){
                if(!isVisited[w]){
                    System.out.print(getVertexByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.offer(w);
                }
                w = getNextNeighbor(u,w);
            }
        }
    }
    public void bfs(){
        bfs(isVisited,0);
    }
}
