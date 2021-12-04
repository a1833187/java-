package com.qrxedu.sparsearray;

import java.io.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        //二维数组转为稀疏数组
        //创建并初始化二维数组存放棋盘
        int[][] chessArray = new int[10][10];
        int row = chessArray.length;
        int col = chessArray[0].length;
        chessArray[1][2] = 1;
        chessArray[3][4] = 2;
        chessArray[5][6] = 2;
        //展示二维数组
        int sum = 0;
        for(int[] row1 : chessArray){
            for(int data: row1){
                if(data != 0){
                    sum++;
                }
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //创建并初始化稀疏数组
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = row;
        sparseArray[0][1] = col;
        sparseArray[0][2] = sum;
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(chessArray[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }
        System.out.println("稀疏数组为:");
        //展示稀疏数组
        for (int[] ints : sparseArray) {
            System.out.printf("%d\t%d\t%d\t\n", ints[0], ints[1], ints[2]);
        }
        //将稀疏数组存入对应文件中
        String filepath = "f:\\sparseArr.txt";
        FileWriter fileWriter = new FileWriter(filepath);
        for(int i = 0; i < sparseArray.length;i++){
            for(int j = 0; j < sparseArray[0].length;j++){
                fileWriter.write(String.valueOf(sparseArray[i][j]+"\n"));
            }
        }
        fileWriter.close();
        System.out.println("=============================================");
        //================================================================
        //稀疏数组转化为二维数组
        int[][] chessArr = new int[sparseArray[0][0]][sparseArray[0][1]];
        for(int i = 1; i < sparseArray.length;i++){
            chessArr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        for(int[] ints : chessArr){
            for(int output : ints){
                System.out.printf("%d\t",output);
            }
            System.out.println();
        }
    }
}
