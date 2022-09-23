package qrxedu.wexam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int sum = 0, mu = 1;
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(dfs(arr,0,sum,mu));
    }
    public static int dfs(int[] arr,int index,int sum,int mu){
        int count = 0;
        for(int i = index; i < arr.length; i++){
            sum+=arr[i];
            mu*=arr[i];
            if(sum > mu){
                count += 1 + dfs(arr,i+1,sum,mu);
            }else if(arr[i] == 1){
                count += dfs(arr,i+1,sum,mu);
            }else{
                break;
            }
            sum-=arr[i];
            mu/=arr[i];
            while(i < arr.length-1 && arr[i] == arr[i+1]){
                i++;
            }
        }
        return count;
    }
}
