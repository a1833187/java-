import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            System.out.println(fibonacci(n));
        }
    }
    public static int fibonacci(int n){
        int n1 = 0;
        int n2 = 1;
        int n3 = 0;
        while(n3 < n){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return Math.min(n-n1,n3-n);
    }

}
