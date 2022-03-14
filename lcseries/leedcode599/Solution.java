package qrxedu.leedcode599;

import qrxedu.hhhh;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String[] findRestaurant1(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length;i++){
            map.put(list1[i],i);
        }
        List<String> cur = new ArrayList<>();
        int minNum = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length;i++){
            if(map.containsKey(list2[i])){
                int j = map.get(list2[i]);
                if(i+j < minNum){
                    cur.clear();
                    cur.add(list2[i]);
                    minNum = i + j;
                }else if(i+j == minNum){
                    cur.add(list2[i]);
                }
            }
        }
        return cur.toArray(new String[cur.size()]);
    }
    public String[] findRestaurant(String[] list1, String[] list2) {
        int[] count = new int[list1.length];
        for(int i = 0; i < list1.length;i++){
            count[i] = i;
        }
        boolean[] flag = new boolean[list1.length];
        for(int i = 0; i < list2.length;i++){
            int index = isContains(list1,list2[i]);
            if(index != -1){
                count[index] += i;
                flag[index] = true;
            }
        }
        int minNum = Integer.MAX_VALUE;
        for(int i = 0; i < list1.length;i++){
            if(flag[i] && minNum > count[i]){
                minNum = count[i];
            }
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < list1.length;i++){
            if(flag[i] && minNum == count[i]){
                res.add(list1[i]);
            }
        }
        String[] r = new String[res.size()];
        for(int i = 0; i < res.size();i++){
            r[i] = res.get(i);
        }
        return r;
    }
    public int isContains(String[] list1,String str){
        for(int i = 0; i < list1.length;i++){
            if(list1[i].equals(str)){
                return i;
            }
        }
        return -1;
    }
}
