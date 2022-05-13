package qrxedu.leedcode069;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while(l < r){
            int mid = (l+r)>>1;
            if(mid-1>=0 && arr[mid] < arr[mid-1]){
                r = mid;
            }else if(mid + 1 < n && arr[mid] < arr[mid+1]){
                l = mid;
            }else{
                return mid;
            }
        }
        //到不了这
        return -1;
    }
}
