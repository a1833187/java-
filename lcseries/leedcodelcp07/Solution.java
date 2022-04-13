package qrxedu.leedcodelcp07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int numWays(int n, int[][] relation, int k) {
        int[][] f = new int[k+1][n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < relation.length;i++){
            int key = relation[i][0];
            if(map.get(key) != null){
                map.get(key).add(relation[i][1]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(relation[i][1]);
                map.put(key,list);
            }
        }
        List<Integer> list = map.get(0);
        for(int i = 0; i < list.size(); i++){
            f[1][list.get(i)] = 1;
        }
        for(int i = 1; i < k; i++){
            for(int j = 0; j < n; j++){
                if(f[i][j] != 0){
                    List<Integer> curList = map.get(j);
                    if(curList != null) {
                        for (int num : curList) {
                            f[i + 1][num] += f[i][j];
                        }
                    }
                }
            }
        }
        return f[k][n-1];
    }
}
