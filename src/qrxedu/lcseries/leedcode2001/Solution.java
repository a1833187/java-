package qrxedu.lcseries.leedcode2001;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
       Arrays.sort(rectangles, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               int flag = 0;
               if(o1[0]*1.0/o1[1] < o2[0]*1.0/o2[1]){
                   flag = -1;
               }else if(o1[0]*1.0/o1[1] > o2[0]*1.0/o2[1]){
                   flag = 1;
               }
               return flag;
           }
       });
       int n = rectangles.length;;
       List<Integer> list = new ArrayList<>();
       for(int i = 0; i < n-1;i++){
           int cnt = 1;
           int[] nums1 = rectangles[i];
           int[] nums2 = rectangles[i+1];
           while(nums1[0] * nums2[1] == nums1[1] * nums2[0]){
               cnt++;
               i++;
               nums1 = rectangles[i];
               nums2 = rectangles[i+1];
           }
           if(cnt > 1){
               list.add(cnt);
           }
       }
       long ans = 0;
       for(int k : list){
           ans += (long) k * (k-1) / 2;
       }
       return ans;
    }
}
