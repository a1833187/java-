package qrxedu.e101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author qiu
 * @version 1.8.0
 */
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class E89 {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start){
                    return o1.start - o2.start;
                }else{
                    return o1.end - o2.end;
                }
            }
        });
        int i = 0;
        while(i < intervals.size()){
            if(i+1<intervals.size() && intervals.get(i).start <= intervals.get(i+1).start && intervals.get(i).end >= intervals.get(i+1).end){
                intervals.remove(i+1);
            }else{
                i++;
            }
        }
        ArrayList<Interval> ans = new ArrayList<>();
        int n = intervals.size();
        int l = 0,r = 0;
        while(r < n){
            while(r+1 < n && intervals.get(r).end >= intervals.get(r+1).start){
                r++;
            }
            Interval cur = new Interval(intervals.get(l).start,intervals.get(r).end);
            ans.add(cur);
            r++;
            l = r;
        }
        return ans;
    }
}
