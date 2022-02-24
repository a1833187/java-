package qrxedu.leedcode692;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //当两个单词的出现频率相同时，将字典中靠后的键值对放在堆顶(因为后面会逆置)
                if(o1.getValue().compareTo(o2.getValue()) == 0){
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for(Map.Entry<String,Integer> i:entries){
            if(priorityQueue.size()<k){
                priorityQueue.offer(i);
            }else{
                Map.Entry<String,Integer> tmp = priorityQueue.peek();
                if(tmp.getValue().compareTo(i.getValue())<0){
                    priorityQueue.poll();
                    priorityQueue.offer(i);
                }else if(tmp.getValue().compareTo(i.getValue()) == 0){
                    if(tmp.getKey().compareTo(i.getKey()) > 0){
                        priorityQueue.poll();
                        priorityQueue.offer(i);
                    }
                }
            }
        }
        List<String> res = new ArrayList<>();
        //TopK问题中小根堆的遍历输出要弹出！
        for(int i = 0; i < k; i++){
            Map.Entry<String,Integer> entry = priorityQueue.poll();
            res.add(entry.getKey());
        }
        Collections.reverse(res);
        return res;
    }
}
