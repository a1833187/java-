package com.qrxedu.lcseries.leedcode661;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[][] imageSmoother(int[][] img) {
        int row = img.length;
        int col = img[0].length;
        int[][] sum = new int[row][col];
        int[][] newImg = new int[row+2][col+2];
        for(int i = 1; i < row+1;i++){
            for(int j = 1; j < col + 1; j++){
                newImg[i][j] = img[i-1][j-1];
            }
        }
        for(int i = 1; i < row + 1; i++){
            for(int j = 1; j < col + 1; j++){
                sum[i-1][j-1] = (newImg[i-1][j-1]+newImg[i-1][j]+newImg[i-1][j+1]+
                        newImg[i][j-1]+newImg[i][j]+newImg[i][j+1]+
                        newImg[i+1][j-1]+newImg[i+1][j]+newImg[i+1][j+1]);
                int k = 0;
                if(i==1&&j==1||(i==1&&j==col)||(i==row&&j==1)||(i==row&&j==col)){
                    if(row == 1 && col == 1){
                        k = 1;
                    }else if(row == 1||col == 1){
                        k = 2;
                    }else{
                        k = 4;
                    }
                }else if(i==1||i==row||j==1||j==col){
                    if(row == 1|| col == 1){
                        k = 3;
                    }else{
                        k = 6;
                    }
                }else{
                    k = 9;
                }
                sum[i-1][j-1] /= k;
            }
        }
        return sum;
    }
}
