package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main57 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            String[] strs = new String[n];
            scanner.nextLine();
            for(int i = 0; i < n; i++) {
                strs[i] = scanner.nextLine();
            }
            for(int i = 0; i < n; i++){
                String s = strs[i];
                if(i != n - 1) {
                    if (s.contains(" ") || s.contains(",")) {
                        System.out.print("\"" + s + "\"" + ", ");
                    }else{
                        System.out.print(s + ", ");
                    }
                }else{
                    if (s.contains(" ") || s.contains(",")) {
                        System.out.print("\"" + s + "\"");
                    }else{
                        System.out.print(s);
                    }
                }
            }
            System.out.println();
        }
    }
}
