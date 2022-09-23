package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E62 {
    public int Fibonacci(int n) {
        int n1 = 1;
        int n2 = 1;
        if(n <= 2){
            return 1;
        }
        int n3 = 1;
        for(int i = 3; i <= n; i++){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }
}
