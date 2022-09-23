package qrxedu.e101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 和活动安排不太一样
 * 主持人调度的起始时间和结束时间
 * @author qiu
 * @version 1.8.0
 */
public class E96 {
    public int minmumNumberOfHost (int n, ArrayList<ArrayList<Integer>> startEnd) {
        // write code here
        int cnt = 0;
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();
        for(ArrayList<Integer> l : startEnd){
            start.add(l.get(0));
            end.add(l.get(1));
        }
        Collections.sort(start);
        Collections.sort(end);
        int j = 0;
        for(int i = 0; i < n; i++){
            if(start.get(i) >= end.get(j)){
                j++;
            }else{
                cnt++;
            }
        }
        return cnt;
    }
}
