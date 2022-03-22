package qrxedu.leedcode733;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    boolean[][] isVisited;
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        isVisited = new boolean[m][n];
        isVisited[sr][sc] = true;
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        dfs(image,sr,sc,oldColor,newColor);
        return image;
    }
    public void dfs(int[][] image,int sr,int sc,int oldColor,int newColor){
        for(int i = 0; i < dir.length;i++){
            int rr = sr + dir[i][0];
            int rc = sc  +dir[i][1];
            if(rr >= 0 && rr < image.length && rc >= 0 && rc < image[0].length
            && !isVisited[rr][rc] && image[rr][rc] == oldColor){
                isVisited[rr][rc] = true;
                image[rr][rc] = newColor;
                dfs(image,rr,rc,oldColor,newColor);
                isVisited[rr][rc] = false;
            }
        }
    }
}
