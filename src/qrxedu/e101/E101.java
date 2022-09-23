package qrxedu.e101;

import java.util.*;

/**
 * LFU:淘汰使用次数最少的:freq确定使用频率,双向链表确定频率相同的记录的使用时间的先后
 * @author qiu
 * @version 1.8.0
 */
public class E101 {
    static class Node{
        int freq;
        int key;
        int val;

        public Node(int freq,int key,int val){
            this.freq = freq;
            this.key = key;
            this.val = val;
        }
    }
    Map<Integer,LinkedList<Node>> freq_mq = new HashMap<>();
    Map<Integer,Node> mq = new HashMap<>();
    int size;
    int min_freq = 0;
    public int[] LFU (int[][] operators, int k) {
        // write code here
        size = k;
        int m = operators.length;
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < size; i++){
            if(operators[i][0] == 1){
                set(operators[i][1],operators[i][2]);
            }else{
                l.add(get(operators[i][1]));
            }
        }
        int[] ans = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            ans[i] = l.get(i);
        }
        return ans;
    }
    public void set(int key,int val){
        //如果mq中存在,那么只是更新freq_mq
        //如果mq中不存在,如果容量为0需要删除频率最小对应的双向链表的尾部节点,然后将新的node放入哈希表中频率为1的双向链表中
        if(mq.containsKey(key)){
            update(mq.get(key),key,val);
        }else{
            if(size == 0){
                int oldKey = freq_mq.get(min_freq).getLast().key;
                freq_mq.get(min_freq).removeLast();
                if(freq_mq.get(min_freq).isEmpty()){
                    freq_mq.remove(min_freq);
                }
                mq.remove(oldKey);
                size++;
            }
            size--;
            min_freq = 1;
            if(!freq_mq.containsKey(1)){
                freq_mq.put(1,new LinkedList<>());
            }
            freq_mq.get(1).addFirst(new Node(1,key,val));

            mq.put(key,freq_mq.get(1).getFirst());
        }
    }
    public void update(Node node,int key,int value){
        //首先把原来freq对应双向链表中的某个node删除掉,然后频率+1,
        // 然后构造一个心频率的node放到新的频率对应的双向链表的头部
        int freq = node.freq;
        freq_mq.get(freq).remove(node);
        if(freq_mq.get(freq).isEmpty()){
            freq_mq.remove(freq);
            if(freq == min_freq){
                min_freq += 1;
            }
        }
        if(!freq_mq.containsKey(freq+1)){
            freq_mq.put(freq+1,new LinkedList<>());
        }
        freq_mq.get(freq+1).addFirst(new Node(freq+1,key,value));
        mq.put(key,freq_mq.get(freq+1).getFirst());
    }
    public int get(int key){
        int res = -1;
        //如果哈希表中存在更新res和双线链表
        if(mq.containsKey(key)){
            res = mq.get(key).val;
            update(mq.get(key),key,res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr  = {{1,1,1},{1,2,2},{1,3,2},{1,2,4},{1,3,5},{2,2},{1,4,4},{2,1}};
        //System.out.println(Arrays.toString(LFU(arr, 3)));
    }
}
