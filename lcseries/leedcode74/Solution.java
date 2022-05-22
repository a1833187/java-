package qrxedu.leedcode74;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[m-1][n-1]){
            return false;
        }
        int l = 0,r = m-1;
        while(l < r){
            int mid = l + r >> 1;
            if(matrix[mid][0] >= target){
                if(matrix[mid][0] == target){
                    return true;
                }
                r = mid - 1;
            }else if(matrix[mid][n-1] <= target){
                if(matrix[mid][n-1] == target){
                    return true;
                }
                l = mid + 1;
            }else{
                l = mid;
                break;
            }
        }
        int k = l;
        l = 0;r = n-1;
        while(l < r){
            int mid = l + r >> 1;
            if(matrix[k][mid] == target){
                return true;
            }else if(matrix[k][mid] > target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return matrix[k][l] == target;
    }
}
