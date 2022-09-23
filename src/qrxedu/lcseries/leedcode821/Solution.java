package qrxedu.lcseries.leedcode821;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符的最短距离:两次遍历:从前和从后遍历取最小值.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> dict = new ArrayList<>();
        int m = s.length();
        for(int i = 0; i < m; i++){
            char ch = s.charAt(i);
            if(ch == c){
                dict.add(i);
            }
        }
        int[] ans = new int[m];
        for(int i = 0; i < m; i++){
            if(s.charAt(i) == c){
                ans[i] = 0;
            }else{
                ans[i] = find(dict,i,0,dict.size()-1);
            }
        }
        return ans;
    }
    public int find(List<Integer> dict,int index,int l,int r){
        if(index < dict.get(l)){
            return dict.get(l) - index;
        }
        if(index > dict.get(r)){
            return index - dict.get(r);
        }
        if(l < r){
            int mid = (l+r)/2;
            if(mid+1<=r && dict.get(mid+1)<index){
                return find(dict,index,mid+1,r);
            }else if(mid -1 >= l && dict.get(mid-1) > index){
                return find(dict,index,l,mid-1);
            }else if(mid+1 <= r && dict.get(mid+1) > index && dict.get(mid) < index){
                return Math.min(dict.get(mid+1)-index,index - dict.get(mid));
            }else if(mid-1 >= l && dict.get(mid) > index && dict.get(mid-1) < index){
                return Math.min(dict.get(mid)-index,index-dict.get(mid-1));
            }
        }
        return -1;
    }
    @Test
    public void show(){
        String s = "loveleedcode";
        char ch = 'e';
        System.out.println(Arrays.toString(shortestToChar(s, ch)));
    }
}
