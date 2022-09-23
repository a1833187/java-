package qrxedu.lcseries.leedcode133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Map<Node,Node> isVisited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        if(isVisited.containsKey(node)){
            return isVisited.get(node);
        }
        Node newNode = new Node(node.val,new ArrayList<>());
        isVisited.put(node,newNode);
        for(Node n : node.neighbors){
            newNode.neighbors.add(cloneGraph(n));
        }
        return newNode;
    }
}
