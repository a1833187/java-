package qrxedu.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
}
