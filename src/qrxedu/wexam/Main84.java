package qrxedu.wexam;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main84 {
    public static void main(String[] args) {
        int[] nums = {4,2,1,2,7,3,1,1};
        System.out.println(findMaxGap(nums,nums.length));
    }
    public static int findMaxGap(int[] A, int n) {
        // write code here
        int[] maxL = new int[n];
        int[] maxR = new int[n];
        int ans = Integer.MIN_VALUE;
        maxL[0] = A[0];
        for(int i = 1; i < n; i++){
            maxL[i] = Math.max(A[i],maxL[i-1]);
        }
        maxR[n-1] = A[n-1];
        for(int i = n - 2; i >= 0; i--){
            maxR[i] = Math.max(A[i],maxR[i+1]);
        }
        for(int i = 0; i < n - 1; i++){
            ans = Math.max(ans,Math.abs(maxL[i]-maxR[i+1]));
        }
        return ans;
    }
}
