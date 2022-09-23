package qrxedu.wexam;



import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main73 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            String ans = "";
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(ch >= '0' && ch <= '9'){
                    ans += ch;
                }
            }
            System.out.println(ans);
        }
    }
}
