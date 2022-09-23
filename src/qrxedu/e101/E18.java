package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E18 {
    public boolean Find(int target, int[][] array) {
        int m = array.length;
        if (m == 0) {
            return false;
        }
        int n = array[0].length;
        if (n == 0) {
            return false;
        }
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (array[i][j] == target) {
                return true;
            }
            if (array[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
