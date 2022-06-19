package qrxedu.offer;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer46 {
    public int translateNum(int num) {
        int n = getK(num);
        if(n == 1 || num == 0){
            return 1;
        }
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = num/(int)(Math.pow(10,n-1-i)) % 10;
        }
        int[] f = new int[n];
        f[0] = 1;
        if(nums[0] == 0 || nums[0]*10+nums[1] >= 26){
            f[1] = 1;
        }else{
            f[1] = 2;
        }
        for(int i = 2; i < n; i++){
            f[i] += f[i-1];
            int key = nums[i-1]*10+nums[i];
            if(nums[i-1] != 0  && key > 0 && key < 26){
                f[i]+=f[i-2];
            }
        }
        return f[n-1];
    }
    public int getK(int n){
        int ans = 0;
        int cur = n;
        while(cur != 0){
            ans++;
            cur /= 10;
        }
        return ans;
    }
    @Test
    public void show(){
        System.out.println(translateNum(25));
    }
}
