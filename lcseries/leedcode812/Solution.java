package qrxedu.leedcode812;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        int m = points.length;
        for(int i = 0; i < m; i++){
            for(int j = i+1; j < m;j++){
                for(int k = j + 1; k < m; k++){
                    int[] a = points[i];
                    int[] b = points[j];
                    int[] c = points[k];
                    int a1 = Math.abs(b[0]-a[0]);
                    int b1 = Math.abs(b[1]-a[1]);
                    int a2 = Math.abs(c[0]-a[0]);
                    int b2 = Math.abs(c[1]-a[1]);
                    double cur = Math.abs((a1*b2-a2*b1)*1.0/2);
                    ans = Math.max(ans,cur);
                }
            }
        }
        return ans;
    }
}
