package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.next();
        String B = scanner.next();
        int count = 0;
        if (isPal(B + A, 0, A.length() + B.length() - 1)) {
            count++;
        }
        for (int i = 0; i < A.length(); i++) {
            StringBuffer s = new StringBuffer();
            s.append(A, 0, i + 1);
            s.append(B);
            s.append(A, i + 1, A.length());
            if (isPal(s.toString(), 0, s.length() - 1)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isPal(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
