package qrxedu.lcseries.leedcode49;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,int[]> map = new HashMap<>();
        List<String> cur = new ArrayList<>();
        for(String i : strs){
            cur.add(i);
        }
        for(int i = 0; i < strs.length;i++){
            String str = strs[i];
            int[] num = new int[26];
            for(int j = 0; j < str.length();j++){
                num[str.charAt(j) - 'a']++;
            }
            map.put(str,num);
        }
        Set<String> set = map.keySet();
        while(cur.size()!=0){
         List<String> list = new ArrayList<>();
         String num = cur.get(0);
         cur.remove(0);
         for(String i : set){
            if(isMatch(map.get(num),map.get(i))){
                list.add(i);
                cur.remove(i);
            }
         }
         res.add(list);
        }
        return res;
    }
    public boolean isMatch(int[] a,int[] b){
        for(int i = 0; i < a.length;i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void show(){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
