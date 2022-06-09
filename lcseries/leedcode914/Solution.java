package qrxedu.leedcode914;

import java.util.*;

/**
 * 所有数的最大公约数大于1
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = deck.length;

        for(int num : deck){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Set<Integer> set = map.keySet();
        List<Integer> ans = new ArrayList<>();
        for(int num : set){
            if(map.get(num) == 1){
                return false;
            }
            ans.add(map.get(num));
        }
        if(ans.size() == 1){
            return true;
        }
        int tmp = gcd(ans.get(0),ans.get(1));
        if(tmp == 1){
            return false;
        }
        for(int i = 1; i < ans.size()-1; i++){
            int cur = gcd(ans.get(i),ans.get(i+1));
            tmp = gcd(cur,tmp);
            if(tmp == 1){
                return false;
            }
        }
        return true;
    }
    public int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a%b);
    }
}
