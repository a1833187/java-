package qrxedu.leedcode17111;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    HashMap<String, List<Integer>> map = new HashMap<>();
    public int findClosest(String[] words, String word1, String word2) {
       int n = words.length;
       for(int i = 0; i < n; i++){
           if(map.containsKey(words[i])){
               map.get(words[i]).add(i);
           }else{
               List<Integer> list = new ArrayList<>();
               list.add(i);
               map.put(words[i],list);
           }
       }
       List<Integer> l1 = map.get(word1);
       List<Integer> l2 = map.get(word2);
       int n1 = l1.size();
       int n2 = l2.size();
       int i1 = 0, i2 = 0;
       int ans = n;
       while(i1 < n1 && i2 < n2){
           if(l1.get(i1) <= l2.get(i2)){
               ans = Math.min(ans,l2.get(i2)-l1.get(i1));
               i1++;
           }else{
               ans = Math.min(ans,l1.get(i1)-l2.get(i2));
               i2++;
           }
       }
       return ans;
    }

}
