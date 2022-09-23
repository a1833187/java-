package qrxedu.graph;

import qrxedu.unionfindset.UnionFindSet;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class GraphByMatrix {
    private static final int INF = Integer.MAX_VALUE;
    private char[] V;
    private int[][] matrix;
    private boolean isDirect;

    public GraphByMatrix(int size, boolean isDirect) {
        V = new char[size];
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(matrix[i], INF);
        }
        this.isDirect = isDirect;
    }

    public void initV(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            V[i] = arr[i];
        }
    }

    /**
     * @param srcV   起点
     * @param destV  终点
     * @param weight 权值
     */
    public void addEdge(char srcV, char destV, int weight) {
        int srcIndex = getIndexOfV(srcV);
        int destIndex = getIndexOfV(destV);
        if (srcIndex == -1 || destIndex == -1) {
            throw new IndexOutOfBoundsException("不存在这样的顶点");
        }
        matrix[srcIndex][destIndex] = weight;
        if (!isDirect) {
            matrix[destIndex][srcIndex] = weight;
        }
    }

    private int getIndexOfV(char v) {
        for (int i = 0; i < V.length; i++) {
            if (V[i] == v) {
                return i;
            }
        }
        return -1;
    }

    public int getDegreeOfV(char v) {
        int index = getIndexOfV(v);
        if (index == -1) {
            throw new IndexOutOfBoundsException("不存在这样的顶点");
        }
        int count = 0;
        for (int i = 0; i < V.length; i++) {
            if (matrix[index][i] != INF) {
                count++;
            }
        }
        if (isDirect) {
            //如果是有向图还需要计算入度
            for (int i = 0; i < V.length; i++) {
                if (matrix[i][index] != INF) {
                    count++;
                }
            }
        }
        return count;
    }

    public void printM() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == INF) {
                    System.out.print("∞ ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void bfs(char v) {
        boolean[] isV = new boolean[V.length];
        Queue<Integer> q = new LinkedList<>();
        int index = getIndexOfV(v);
        q.offer(index);
        isV[index] = true;
        while(!q.isEmpty()){
            int size = q.size();
            while(size != 0){
                int cur = q.poll();
                System.out.print(V[cur]+" ->");
                for(int i = 0; i < V.length; i++){
                    if(!isV[i] && matrix[cur][i] != INF){
                        isV[i] = true;
                        q.offer(i);
                    }
                }
                size--;
            }
        }
    }
    public void dfs(char v){
        boolean[] isV = new boolean[V.length];
        int index= getIndexOfV(v);
        dfs(index,isV);
    }
    private void dfs(int index,boolean[] isV){
        System.out.println(V[index] + " ->");
        isV[index] = true;

        for(int i = 0; i < V.length; i++){
            if(matrix[index][i] != INF && !isV[i]){
                dfs(i,isV);
            }
        }
    }

    static class Edge{
        public int srcIndex;
        public int destIndex;
        public int weight;

        public Edge(int srcIndex, int destIndex, int weight) {
            this.srcIndex = srcIndex;
            this.destIndex = destIndex;
            this.weight = weight;
        }
    }
    public int kruskal(GraphByMatrix minTree){
        PriorityQueue<Edge> p = new PriorityQueue<>();
        for(int i = 0;i < matrix.length; i++){
            for(int j = i + 1; j < matrix.length; j++){
                if(matrix[i][j] != INF){
                    Edge e = new Edge(i,j,matrix[i][j]);
                    p.offer(e);
                }
            }
        }
        //用并查集判断是否构成回路
        UnionFindSet ufs = new UnionFindSet(V.length);
        int cnt = 0;
        int total = 0;
        while(cnt != V.length-1 && !p.isEmpty()){
            Edge e = p.poll();
            if(ufs.isSameUnion(e.srcIndex,e.destIndex)){
                continue;
            }
            minTree.matrix[e.srcIndex][e.destIndex] = e.weight;
            minTree.matrix[e.destIndex][e.srcIndex] = e.weight;
            ufs.union(e.srcIndex,e.destIndex);
            System.out.println("选择的边" + V[e.srcIndex] + "->" + V[e.destIndex] + ":"+e.weight);
            total += e.weight;
            cnt++;
        }
        return cnt == V.length - 1 ? total : -1;
    }

    public int prime(GraphByMatrix minTree,char v){
        int srcIndex = getIndexOfV(v);
        Set<Integer> setX = new HashSet<>();
        setX.add(srcIndex);
        PriorityQueue<Edge> p = new PriorityQueue<>();
        for(int i = 0; i < V.length; i++){
            if(matrix[srcIndex][i] != INF){
                p.offer(new Edge(srcIndex,i,matrix[srcIndex][i]));
            }
        }
        int size = 0;
        int total = 0;
        while(!p.isEmpty()){
            Edge e = p.poll();
            int src = e.srcIndex;
            int dest = e.destIndex;
            int weight = e.weight;
            if(setX.contains(dest)){
                return -1;
            }else{
                minTree.matrix[src][dest] = weight;
                minTree.matrix[dest][src] = weight;
                size++;
                total += weight;
                setX.add(dest);
                if(size == V.length-1){
                    return total;
                }
            }
            for(int i = 0; i < V.length; i++){
                if(matrix[dest][i] != INF && !setX.contains(i)){
                    p.offer(new Edge(dest,i,matrix[dest][i]));
                }
            }
        }
        return -1;
    }

    public void dijkstra(char src,int[] dist,int[] pPath){
        int srcIndex = getIndexOfV(src);
        Arrays.fill(dist,INF);
        dist[srcIndex] = 0;
        Arrays.fill(pPath,-1);
        dist[srcIndex] = 0;
        int n = V.length;
        boolean[] s = new boolean[n];

        for(int k = 0; k < n; k++){
            int u = srcIndex;
            int min = INF;
            for(int i = 0; i < n; i++){
                if(!s[i] && dist[i] < min){
                    min = dist[i];
                    u = i;
                }
            }
            s[u] = true;

            for(int v = 0; v < n; v++){
                if(!s[v] && matrix[u][v] != INF && dist[u] + matrix[u][v] < dist[v]){
                    dist[v] = dist[u] + matrix[u][v];
                    pPath[v] = u;
                }
            }
        }
    }
    public void printShortPath(char src,int[] dist,int[] pPath){
        int srcIndex = getIndexOfV(src);
        int n = V.length;
        for(int i = 0; i < n; i++){
            if(i == srcIndex){
                continue;
            }
            ArrayList<Integer> l = new ArrayList<>();
            int p = i;
            while(p != srcIndex){
                l.add(pPath[p]);
                p = pPath[p];
            }
            l.add(srcIndex);
            Collections.reverse(l);
            for(int index : l){
                System.out.print(V[index] + " ->");
            }
            System.out.print(dist[i]);
            System.out.println();
        }
    }
    public boolean bellmanFord(char src,int[] dist,int[] pPath){
        int srcIndex = getIndexOfV(src);
        Arrays.fill(dist,INF);
        dist[srcIndex] = 0;
        Arrays.fill(pPath,-1);
        dist[srcIndex] = 0;
        int n = V.length;

        //存在负权需要对每个点松弛n-1次.
        for(int k = 0;k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] != INF && dist[i] + matrix[i][j] < dist[j]) {
                        dist[j] = dist[i] + matrix[i][j];
                        pPath[j] = i;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] != INF && dist[i]+matrix[i][j] < dist[j]){
                    return false;
                }
            }
        }
        return true;
    }
    public void floydWarShall(int[][] dist,int[][] pPath){
        int n = V.length;
        //pPath[i][j]表示i-j的最短路径上j的前一个点为pPath[i][j]

        //初始化:dist[i][i] = 0,dist[i][j] = martix[i][j]
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i],INF);
            Arrays.fill(pPath[i],-1);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] != INF){
                    dist[i][j] = matrix[i][j];
                    pPath[i][j] = i;
                 }else{
                    dist[i][j] = INF;
                    pPath[i][j] = -1;
                }
                if(i == j){
                    dist[i][j] = 0;
                    pPath[i][j] = -1;
                }
            }
        }

        //更新以第k个点为中间结点中转的过程
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][i] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pPath[i][j] = pPath[k][j];
                    }
                }
            }
        }
    }
}
