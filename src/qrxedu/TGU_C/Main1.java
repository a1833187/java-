package qrxedu.TGU_C;

import java.util.Scanner;

public class Main1 {
    public static long res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        mergeSort(arr,0,arr.length-1);
        System.out.println(res);
    }
    public static void mergeSort(int[] arr, int start, int end){
        if(start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }
    public static void merge(int[] arr,int start,int mid,int end){
        int[] left = new int[mid - start +1];
        int[] right = new int[end - mid];
        System.arraycopy(arr, start, left, 0, left.length);
        System.arraycopy(arr,mid+1,right,0,right.length);
        int i = 0,j = 0;
        int index = start;
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                arr[index++] = left[i++];
            }else{
                arr[index++] = right[j++];
                res+= left.length - i;
            }
        }
        if(i == left.length){
            for(;index <= end; index++){
                arr[index] = right[j++];
            }
        }else{
            for(;index <= end; index++){
                arr[index] = left[i++];
            }
        }
    }
}
