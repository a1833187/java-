package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E52 {
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        int ans = 0;
        int n = array.length;
        for(int i = 0; i < n; i++){
            ans ^= array[i];
        }
        int k = 0;
        while(((ans >> k) & 1) == 0){
            k++;
        }
        int ans1 = 0;
        int ans2 = 0;
        for(int i = 0; i < n; i++){
            int num = array[i];
            if(((num >> k) & 1) == 0){
                ans1 ^= num;
            }else{
                ans2 ^= num;
            }
        }
        if(ans1 > ans2){
            int tmp = ans1;
            ans1 = ans2;
            ans2 = tmp;
        }
        return new int[]{ans1,ans2};
    }
}
