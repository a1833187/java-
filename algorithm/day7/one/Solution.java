package qrxedu.algorithm.day7.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<String> permutation(String str){
        List<String> list = new ArrayList<>();
        if(str == null){
            return list;
        }
        permutation(str,0,list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return list;
    }
    public void permutation(String str,int start,List<String> list){
        if(start == list.size() - 1){
            if(!list.contains(str)){
                list.add(str);
            }
            return;
        }
        for(int i = start;i < list.size();i++){
            str = swap(str,start,i);
            permutation(str,start+1,list);
            str = swap(str,start,i);
        }
    }
    public String swap(String str,int i,int j){
        StringBuffer sb = new StringBuffer(str);
        String tmp = sb.substring(i,i+1);
        sb.replace(i,i+1,sb.substring(j,j+1));
        sb.replace(j,j+1,tmp);
        return sb.toString();

    }
}
