package qrxedu.leedcode434a;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 搜索最短路径用bfs而不是用dfs
 * @author qiu
 * @version 1.8.0
 */
public class Solution1 {
    char[] dict = {'A','T','C','G'};
    Set<String> set = new HashSet<>();
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)){
            return 0;
        }
        for(String str : bank){
            set.add(str);
        }
        if(!set.contains(end)){
            return -1;
        }
        Set<String> v = new HashSet<>();
        Deque<String> q = new LinkedList<>();
        q.offer(start);
        v.add(start);
        int cnt = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int l = 0; l < size; l++) {
                String cur = q.poll();
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (dict[j] != cur.charAt(i)) {
                            StringBuffer curS = new StringBuffer(cur);
                            curS.setCharAt(i, dict[j]);
                            String s = new String(curS);
                            if (!v.contains(s) && set.contains(s)) {
                                if (s.equals(end)) {
                                    return cnt;
                                }
                                q.offer(s);
                                v.add(s);
                            }
                        }
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}
