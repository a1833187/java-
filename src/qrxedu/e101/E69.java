package qrxedu.e101;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E69 {
    public int solve(String nums) {
        // write code here
        int n = nums.length();
        if(nums.charAt(0) == '0'){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        for(int i = 0; i < n-1; i++){
            if(nums.charAt(i) == nums.charAt(i+1) && nums.charAt(i) == '0'){
                return 0;
            }
            if(Integer.parseInt(nums.charAt(i)+"") > 2 && Integer.parseInt(nums.charAt(i+1)+"") == 0){
                return 0;
            }
        }
        int[] f = new int[n];
        f[0] = 1;
        int cur = Integer.parseInt(nums.substring(0,2));
        if(cur >= 1 && cur <= 26 && nums.charAt(1) != '0'){
            f[1] = 2;
        }else{
            f[1] = 1;
        }
        for(int i = 2; i < n; i++){
            char c1 = nums.charAt(i);
            char c2 = nums.charAt(i-1);
            if(c1 == '0' || c2 == '0'){
                f[i] = f[i-2];
            }else{
                cur = Integer.parseInt(nums.substring(i-1,i+1));
                if(cur >= 1 && cur <= 26){
                    f[i] = f[i-1]+f[i-2];
                }else{
                    f[i] = f[i-1];
                }
            }
        }
        return f[n-1];
    }
    @Test
    public void show(){
        String s = "31717126241541717";
        System.out.println(solve(s));
    }
}
