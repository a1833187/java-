package qrxedu.lcseries.leedcode621;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    static class Pair{
        char key;
        int value;
        Pair(char key,int value){
            this.key = key;
            this.value = value;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for(char ch : tasks){
            cnt[ch-'A']++;
        }

        PriorityQueue<Pair> p = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.value == o2.value){
                    return cnt[o2.key-'A'] - cnt[o1.key-'A'];
                }
                return o1.value - o2.value;
            }
        });

        for(int i = 0; i < 26; i++){
            if(cnt[i] != 0){
                p.offer(new Pair((char) (i+'A'),1));
            }
        }
        int time = 0;
        while(!p.isEmpty()){
            Pair pair = p.poll();
            time+=pair.value;
            cnt[pair.key-'A']--;
            List<Pair> l = new ArrayList<>();
            for(Pair cur : p){
                if(cur.value > 1){
                    cur.value = Math.max(cur.value - (pair.value), 1);
                }
                l.add(new Pair(cur.key,cur.value));
            }
            p.clear();
            for(Pair cur : l){
                p.offer(cur);
            }
            if(cnt[pair.key-'A'] != 0){
               pair.value = 1 + n;
               p.offer(pair);
            }
        }
        return time;
    }
    @Test
    public void show(){
        char[] tasks1 =  {'A','B','C','D','E','F','G'};
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        System.out.println(leastInterval(tasks,2));
    }
}
