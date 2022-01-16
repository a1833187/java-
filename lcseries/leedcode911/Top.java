package com.qrxedu.lcseries.leedcode911;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题解
 * @author qiu
 * @version 1.8.0
 */
public class Top {
    int[] times;
    List<Integer> list;
    Map<Integer,Integer> map;
    public Top(int[] persons,int[] times){
        this.times = times;
        map = new HashMap<>();
        map.put(-1,-1);
        int top = -1;
        for(int i = 0; i < persons.length;i++){
            int p = persons[i];
            map.put(p,map.getOrDefault(p,0)+1);
            if(map.get(p)>=map.get(top)){
                top = p;
            }
            list.add(top);
        }
    }
    public int q(int t){
        int l = 0;
        int r = times.length-1;
        while(l<r){
            int mid = l+(r-l+1)/2;
            if(t<mid){
                r = mid-1;
            }
            if(t>=mid){
                l = mid;
            }
        }
        return map.get(l);
    }

}
