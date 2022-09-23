package qrxedu.wexam;

import java.util.Scanner;

/**
 * 移动光标
 * @author qiu
 * @version 1.8.0
 */
public class Main36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i+1;
        }
        int m = s.length();
        int key = arr[0];
        if(n <= 4){
            for(int i = 0;i < m; i++){
                char ch = s.charAt(i);
                if(ch == 'U' && key == 1){
                    key = 3;
                }else if(ch == 'D' && key == n){
                    key = 1;
                }else if(ch == 'U'){
                    key = key-1;
                }else if(ch == 'D'){
                    key = key + 1;
                }
            }
            for(int i = 0; i < n; i++){
                if(i != n-1){
                    System.out.print(i+1 + " ");
                }else{
                    System.out.print(i+1);
                }
            }
            System.out.println();
            System.out.println(key);
            return;
        }
        int[] page = {1,2,3,4};
        for(int i = 0; i < m; i++){
            char ch = s.charAt(i);
            if(ch == 'U' && key == page[0] && page[0] == 1){
                page[0] = n-3;
                page[1] = n-2;
                page[2] = n-1;
                page[3] = n;
                key = page[3];
            }else if(ch == 'D' && key == page[3] && page[0] == n-3){
                page[0] = 1;
                page[1] = 2;
                page[2] = 3;
                page[3] = 4;
                key = page[0];
            }else if(ch == 'U' && key == page[0] &&page[0] != 1){
                page[3] = page[2];
                page[2] = page[1];
                page[1] = page[0];
                page[0] = page[0]-1;
                key = page[0];
            }else if(ch == 'D' && key == page[3] && page[0] != n-3){
                page[0] = page[1];
                page[1] = page[2];
                page[2] = page[3];
                page[3] = page[3]+1;
                key = page[3];
            }else if(ch == 'U'){
                key = key-1;
            }else if(ch == 'D'){
                key = key+1;
            }
        }
        for(int i = 0; i < 4; i++) {
            if (i != 3) {
                System.out.print(page[i] + " ");
            }else{
                System.out.print(page[i]);
            }
        }
        System.out.println();
        System.out.println(key);
    }
}
