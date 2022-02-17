package qrxedu.leedcode537;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int k1 = 0,k2 = 0;
        for(int i = 0; i < num1.length();i++){
            if(num1.charAt(i) == '+'){
                k1 = i;
                break;
            }
        }
        for(int i = 0; i < num2.length();i++){
            if(num2.charAt(i) == '+'){
                k2 = i;
                break;
            }
        }
        int n1 = Integer.parseInt(num1.substring(0,k1));
        int n2 = Integer.parseInt(num1.substring(k1,num1.length()-1));
        int n3 = Integer.parseInt(num2.substring(0,k2));
        int n4 = Integer.parseInt(num2.substring(k2,num2.length()-1));
        int res1 = n1 * n3 - n2 * n4;
        int res2 = n1 * n4 + n2 * n3;
        return "" + res1 + "+" +  "" + res2 + "i";
    }
}
