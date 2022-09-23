package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer70 {
    public int add(int a, int b) {
        while(b != 0){
            int c = (a & b) << 1;
            a = a ^ b;
            b = c;
        }
        return a;
    }
}
