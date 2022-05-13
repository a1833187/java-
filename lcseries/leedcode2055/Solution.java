package qrxedu.leedcode2055;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
       List<Integer> list = new ArrayList<>();
        int n = s.length();
        int m = queries.length;
        int[] ans = new int[m];
        int[] sum = new int[n+1];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '|'){
               list.add(i);
               sum[i+1] = sum[i];
            }else{
                sum[i+1] = sum[i]+ 1;
            }
        }
        if(list.size() == 0){
            return ans;
        }
        for(int i = 0; i < m; i++){
            int b = queries[i][0];
            int a = queries[i][1];
            int l = 0,r = list.size()-1;
            int c = -1,d = -1;
            while(l < r){
                int mid = l+r>>1;
                if(list.get(mid) >= b){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
            if(list.get(r) >= b){
                c = list.get(r);
            }else{
                continue;
            }
            l = 0;r = list.size()-1;
            while(l < r){
                int mid = l + r + 1 >> 1;
                if(list.get(mid) <= a){
                    l = mid;
                }else{
                    r = mid - 1;
                }
            }
            if(list.get(r) <= a){
                d = list.get(r);
            }else{
                continue;
            }
            if(c <= d){
                ans[i] = sum[d+1]-sum[c];
            }


        }
        return ans;
    }
    @Test
    public void show(){
        String s = "**|**|***|";
        int[][] q = {{2,5},{5,9}};
        System.out.println(Arrays.toString(platesBetweenCandles(s, q)));
    }
    public int[] platesBetweenCandles1(String s, int[][] queries) {
        int n = s.length();
        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }
        //left[i]表示是i位置左侧最近的蜡烛的位置
        int[] left = new int[n];
        for (int i = 0, l = -1; i < n; i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }

        //right[i]表示i位置右侧最近的蜡烛的位置
        int[] right = new int[n];
        for (int i = n - 1, r = -1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = right[query[0]], y = left[query[1]];
            ans[i] = x == -1 || y == -1 || x >= y ? 0 : preSum[y] - preSum[x];
        }
        return ans;
    }
}
