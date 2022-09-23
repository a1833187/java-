package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer71 {
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] leftM = new int[n];
        int[] rightM = new int[n];
        int[] ans = new int[n];
        if(n == 0){
            return ans;
        }
        leftM[0] = 1;
        rightM[n-1] = 1;
        for(int i = 1; i < n; i++){
            leftM[i] = a[i-1]*leftM[i-1];
        }
        for(int i = n-2; i >= 0; i--){
            rightM[i] = rightM[i+1] * a[i+1];
        }

        for(int i = 0; i < n; i++){
            ans[i] = leftM[i] * rightM[i];
        }
        return ans;
    }
}
