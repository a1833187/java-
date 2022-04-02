package qrxedu.wexam;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int abDiff = scanner.nextInt();
        int bcDiff = scanner.nextInt();
        int abSum = scanner.nextInt();
        int bcSum = scanner.nextInt();
        int a = (abDiff+abSum)/2;
        if(a < 0 || a*2 != abDiff+abSum){
            System.out.println("No");
            return;
        }
        int b = a - abDiff;
        if(b < 0){
            System.out.println("No");
            return;
        }
        int c = b - bcDiff;
        if(c < 0){
            System.out.println("No");
            return;
        }
        if(b+c != bcSum){
            System.out.println("No");{
                return;
            }
        }
        System.out.println(a + " " + b + " " + c);
    }
}
