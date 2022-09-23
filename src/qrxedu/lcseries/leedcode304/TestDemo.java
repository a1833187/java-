package qrxedu.lcseries.leedcode304;

/**
 * @author qiu
 * @version 1.8.0
 */
public class TestDemo {
    public static void main(String[] args) {
        int[][] matrix = new int[2][1];
        matrix[0][0] = 1;
        matrix[1][0] = -7;
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(1,0,1,0));
    }
}
