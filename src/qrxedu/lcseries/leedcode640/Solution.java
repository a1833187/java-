package qrxedu.lcseries.leedcode640;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String solveEquation(String equation) {
        String[] a = equation.split("=");
        String o1 = a[0];
        String o2 = a[1];
        int i = 0, j = 0;
        int sum1 = sumX(o1);
        int sum2 = sumX(o2);
        int sum3 = sumC(o1);
        int sum4 = sumC(o2);
        int res1 = sum1 - sum2;
        int res2 = sum4 - sum3;
        if (res1 == 0 && res2 == 0) {
            return "Infinite solutions";
        } else if (res2 != 0 && res1 == 0) {
            return "No solution";
        } else {
            return "x=" + "" + res2 / res1;
        }

    }

    public int sumX(String o1) {
        int sum1 = 0, i = 0;
        StringBuilder sb = new StringBuilder(o1);
        sb.append('+');
        if(sb.charAt(0) != '-'){
            sb.insert(0,'+');
        }
        o1 = sb.toString();
        while (i < o1.length()) {
            if (o1.charAt(i) == 'x') {
                int k = i;
                while (k >= 0) {
                    if (o1.charAt(k) != '+' && o1.charAt(k) != '-') {
                        k--;
                    } else {
                        break;
                    }
                }
                if (k == -1) {
                    sum1 += 1;
                }
                if (k >= 0) {
                    if (i - k == 1 && o1.charAt(k) == '+') {
                        sum1 += 1;
                    } else if (i - k == 1 && o1.charAt(k) == '-') {
                        sum1 -=1;
                    } else {
                        sum1 += Integer.parseInt(o1.substring(k, i));
                    }
                }
            }
            i++;
        }
        return sum1;
    }

    public int sumC(String o1) {
        int left = 0, right = 0;
        int sum1 = 0;
        StringBuilder sb = new StringBuilder(o1);
        sb.append('+');
        if(sb.charAt(0) != '-'){
            sb.insert(0,'+');
        }
        o1 = sb.toString();
        while (right < o1.length()) {
            while (left < o1.length() && !(o1.charAt(left) == '+' || o1.charAt(left) == '-')) {
                left++;
            }
            right = left + 1;
            while (right < o1.length() && !(o1.charAt(right) == '+' || o1.charAt(right) == '-')) {
                right++;
            }
            if (right < o1.length() && !o1.substring(left,right).contains("x")) {
                sum1 += Integer.parseInt(o1.substring(left, right));
            }
            left = right;
        }
        return sum1;
    }

    @Test
    public void show() {
        String a = "2x=x";
        String[] b = a.split("=");
        System.out.println(solveEquation(a));
    }

}
