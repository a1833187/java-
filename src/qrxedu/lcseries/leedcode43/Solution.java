package qrxedu.lcseries.leedcode43;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] ans = new int[402];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int curNum1 = Integer.parseInt(num1.charAt(i)+"");
                int curNum2 = Integer.parseInt(num2.charAt(j)+"");
                int index = m-1-i+n-1-j+1;
                int res = curNum1*curNum2;
                int k = 0;
                while(index < 402 && (k != 0 || res != 0)){
                    if(res != 0){
                        int ret = (ans[index] + res%10 + k);
                        if(ret >= 10){
                            k = 1;
                        }else{
                            k = 0;
                        }
                        ans[index] = ret % 10;
                        res /= 10;
                    }else{
                        int ret = (ans[index]+k);
                        if(ret >= 10){
                            k = 1;
                        }else{
                            k = 0;
                        }
                        ans[index] = ret % 10;
                    }
                    index++;
                }
            }
        }
        String s = "";
        int i = ans.length-1;
        while(i > 0 && ans[i] == 0){
            i--;
        }
        for(; i > 0;i--){
            s+=ans[i];
        }
        return s;
    }
    @Test
    public void show(){
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1,num2));
    }
}
