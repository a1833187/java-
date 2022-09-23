package qrxedu.lcseries.leedcode85;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int m = matrix.length;
        if(m == 0){
            return 0;
        }
        int res = 0;
        int n= matrix[0].length;
        int[] up = new int[m];
        int[] down = new int[m];
        int[][] left = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    left[i][j] = (j == 0?0:left[i][j-1]) + 1;
                }
            }
        }
        for(int j = 0; j  < n; j++){
            Deque<Integer> stack = new LinkedList<>();
            for(int i = 0; i < m; i++){
                while(!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]){
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1:stack.peek();
                stack.push(i);
            }
            stack.clear();
            for(int i = m-1; i >= 0; i--){
                while(!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]){
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m:stack.peek();
                stack.push(i);
            }
            for(int i = 0; i < m; i++){
                int height = down[i] - up[i] - 1;
                int area = left[i][j]  * height;
                res = Math.max(res,area);
            }
        }
        return res;
    }

    @Test
    public void show() {
        char[][] chars = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(chars));
    }
}
