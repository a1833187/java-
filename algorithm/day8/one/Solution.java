package qrxedu.algorithm.day8.one;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n > 0){
            String str = scanner.next();
            System.out.println(new Solution().findTheChar(str));
            n--;
        }
    }
    public int findTheChar(String str){
        int left = 0;
        int right = str.length()-1;
        int k = -1;
        int res = right;
        boolean flag = true;
        while(left < right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }else{
                if(k == -1){
                    k = left;
                    res = right;
                    left++;
                }else{
                    flag = false;
                    break;
                }
            }
        }
        if(flag){
           return k;
        }else{
            return res;
        }
    }
}
