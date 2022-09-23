package qrxedu.e101;

import java.util.ArrayList;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E98 {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> l = new ArrayList<>();
        int m = matrix.length;
        if(m == 0){
            return l;
        }
        int n = matrix[0].length;
        int left = 0,right = n-1;
        int top = 0,bottom = m-1;
        while(left <= right && top <= bottom){
            for(int i = left; i <= right;i++){
                l.add(matrix[top][i]);
            }
            for(int i = top+1;i <= bottom;i++){
                l.add(matrix[i][right]);
            }
            if(left == right || top == bottom){
                break;
            }
            for(int i = right-1;i>=left;i--){
                l.add(matrix[bottom][i]);
            }
            for(int i = bottom-1; i>= top+1;i--){
                l.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return l;
    }
}
