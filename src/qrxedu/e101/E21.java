package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E21 {
    public int minNumberInRotateArray(int [] array) {
        int l = 0,r = array.length - 1;
        while(l < r){
            int mid = l + r >> 1;
            if(array[mid] == array[r]){
                r--;
            }else if(array[mid] < array[r]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return array[l];
    }
}
