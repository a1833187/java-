package qrxedu.lcseries.leedcode30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int m = s.length();
        int n =  words.length;
        int len = words[0].length();
        List<Integer> l =  new ArrayList<>();
        if(m < n * len){
            return l;
        }
        len = n * len;
        for(int i = 0; i + len <= m; i++){
            String sub = s.substring(i,i+len);
            if(isEqual(sub,words)){
                l.add(i);
            }
        }
        return l;
    }
    private boolean isEqual(String sub,String[] words){
        StringBuilder s = new StringBuilder(sub);
        int n = words.length;
        int len = words[0].length();
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        while(s.length() != 0){
            String str = s.substring(0,len);
            if(map.containsKey(str)){
                map.put(str,map.get(str)-1);
                if(map.get(str) == 0){
                    map.remove(str);
                }
                s.delete(0,len);
            }else{
                return false;
            }
        }
        return true;
    }
}
