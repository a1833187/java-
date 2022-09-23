package qrxedu.graph;

import java.util.ArrayList;

/**
 * @author qiu
 * @version 1.8.0
 */
public class GraphByNode {
    public static final int INF = Integer.MAX_VALUE;

    public  char[] V;

    public ArrayList<Node> edgeList;

    public boolean isDirect;
    static class Node{
        public int src;
        public int dest;
        public int weight;
        public Node next;
        public Node(int src,int dest,int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public GraphByNode(int size,boolean isDirect){
        V = new char[size];
        edgeList = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            edgeList.add(null);
        }
        this.isDirect = isDirect;
    }
    public void initV(char[] arr){
        for(int i = 0; i < arr.length; i++){
            V[i] = arr[i];
        }
    }

    private void addEdgeChild(int src,int dest,int weight){
        Node cur = edgeList.get(src);
        while(cur != null){
            if(cur.dest == dest){
                return;
            }
            cur = cur.next;
        }
        Node node = new Node(src,dest,weight);
        node.next = edgeList.get(src);
        edgeList.set(src,node);
    }
    private int getIndexOfV(char v){
        for(int i = 0; i < V.length; i++){
            if(V[i] == v){
                return i;
            }
        }
        return -1;
    }

    public void addEdge(char src,char dest,int weight){
        int srcIndex = getIndexOfV(src);
        int destIndex = getIndexOfV(src);

        addEdgeChild(srcIndex,destIndex,weight);

        if(!isDirect){
            addEdgeChild(destIndex,srcIndex,weight);
        }
    }

    public void printGraph(){
        for(int i = 0; i < V.length; i++){
            System.out.print(V[i] + " ->");
            Node cur = edgeList.get(i);
            while(cur != null){
                System.out.print(cur.dest+" ->");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    public int getDegree(char v){
        int index = getIndexOfV(v);
        Node cur = edgeList.get(v);
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        //如果是有向图, 还需要计算入度:遍历整个邻接表
        if(isDirect){
            for(int i = 0; i < V.length && i != index; i++){
                cur = edgeList.get(i);
                while(cur != null){
                    if(cur.dest == index){
                        count++;
                    }
                    cur = cur.next;
                }
            }
        }
        return count;
    }
}
