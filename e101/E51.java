package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E51 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int n = array.length;
        int time = 1;
        int ans = array[0];
        for(int i = 1; i < n; i++){
            int num = array[i];
            if(time == 0){
                time = 1;
                ans = array[i-1];
            }
            if(ans == num){
                time++;
            }else{
                time--;
            }
        }
        return ans;
    }
}
