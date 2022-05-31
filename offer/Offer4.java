package qrxedu.offer;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer4 {
    int[][] mat;
    int t;
    int m,n;
    //基于每一行每一列进行二分查找
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        mat = matrix;
        t = target;
        m = mat.length;
        n = mat[0].length;
        boolean flag = false;
        for(int i = 0; i < m; i++){
            flag = check(i);
            if(flag){
                return true;
            }
        }
        return false;
    }
    public boolean check(int ll){
        int l = ll;
        int r = m-1;
        if(ll < n) {
            while (l < r) {
                int mid = l + r >> 1;
                if (mat[mid][ll] == t) {
                    return true;
                }
                if (mat[mid][ll] > t) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (mat[l][ll] == t) {
                return true;
            }
        }
        l = ll;
        r = n-1;
        while(l < r){
            int mid = l + r >> 1;
            if(mat[ll][mid] == t){
                return true;
            }
            if(mat[ll][mid] > t){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        if(l < n && mat[ll][l] == t){
            return true;
        }
        return false;
    }
    //从右上角开始往左下角开始查找(这个方法还挺秀的)
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        mat = matrix;
        t = target;
        m = mat.length;
        n = mat[0].length;
        if(mat == null || m == 0){
            return false;
        }
        int i = 0,j = n-1;
        while(i < m && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }
            if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
    @Test
    public void show(){
        int[][] m = {{1,4,7,11,15},
                    {2,5,8,12,19},
                    {3,6,9,16,12},
                    {10,13,14,17,24},
                    {18,21,23,26,30}};
        System.out.println(findNumberIn2DArray1(m,5));
    }
}
