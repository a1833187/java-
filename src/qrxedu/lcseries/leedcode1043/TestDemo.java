package qrxedu.lcseries.leedcode1043;

/**
 * @author qiu
 * @version 1.8.0
 */
public class TestDemo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{2,1,1,2},{1,1,1,1},{2,1,2,2}};
        int row = 1;
        int col = 1;
        int color = 4;
        grid = solution.draw(grid,row,col,color);
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i< m;i++){
            for(int j = 0; j < n;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
