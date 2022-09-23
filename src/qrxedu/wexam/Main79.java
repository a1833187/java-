package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main79 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String A= scanner.next();
            String B = scanner.next();
            int[] countA = new int[26];
            int[] countB = new int[26];
            for(int i = 0; i < A.length(); i++){
                countA[A.charAt(i)-'A']++;
            }
            for(int i = 0; i < B.length(); i++){
                countB[B.charAt(i)-'A']++;
            }
            boolean flag = true;
            for(int i = 0; i < 26; i++){
                if(countB[i] > countA[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
