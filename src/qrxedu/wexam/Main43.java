package qrxedu.wexam;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 大数运算
 * @author qiu
 * @version 1.8.0
 */
public class Main43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            BigDecimal n = scanner.nextBigDecimal();
            BigDecimal r = scanner.nextBigDecimal();
            BigDecimal c = new BigDecimal(6.28);
            BigDecimal C = r.multiply(c);
            if(C.compareTo(n) < 0){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
        }
    }
}
