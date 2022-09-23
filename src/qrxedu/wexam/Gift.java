package qrxedu.wexam;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
        int time = 1;
        int num = gifts[0];
        for(int i = 1; i < n; i++){
            if(time == 0){
                time = 1;
                num = gifts[i-1];
            }
            if(num != gifts[i]){
                time--;
            }
            if(num == gifts[i]){
                time++;
            }
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(gifts[i] == num){
                cnt++;
            }
        }
        return cnt > gifts.length/2 ? num : 0;
    }
}
