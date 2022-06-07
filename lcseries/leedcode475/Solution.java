package qrxedu.leedcode475;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0;
        int r = Math.max(heaters[heaters.length-1],houses[houses.length-1])
                - Math.min(houses[0],heaters[0]);
//        int l = 0,r = (int)1e9;
        while(l < r){
            int mid = l + r >> 1;
            if(check(houses,heaters,mid)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    public boolean check(int[] houses,int[] heaters,int r){
        int m = houses.length;
        int n = heaters.length;
        for(int i = 0,j = 0;i < m; i++){
            while(j < n && houses[i] > heaters[j]+r){
                j++;
            }
            if(j < n && houses[i] >= heaters[j]-r && houses[i] <= heaters[j]+r){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}
