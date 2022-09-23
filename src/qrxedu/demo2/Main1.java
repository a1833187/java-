package qrxedu.demo2;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main1 {
    static int cnt;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        cnt = 0;
        getNum(arr,0,arr.length-1);
        System.out.println(cnt);
    }
    public static void getNum(int[] arr,int left,int right){
        if(left > right){
            return;
        }
        int min = getMin(arr,left,right);
        func(arr,left,right,min);
        cnt+=min;
        int i = left;
        int j = left;
        while(i <= right){
            while(j <= right && arr[j] != 0){
                j++;
            }
            getNum(arr,i,j-1);
            while(j <= right && arr[j] == 0){
                j++;
            }
            i = j;
        }


    }
    public static void func(int[] arr,int left, int right,int key){
        for(int i = left; i <= right; i++){
            arr[i]-=key;
        }
    }
    public static int getMin(int[] arr,int left,int right){
        int min = arr[left];
        for(int i = left+1; i <= right; i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
}
