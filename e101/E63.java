package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E63 {
    public int jumpFloor(int target) {
        int[] f = new int[target+1];
        f[0] = 1;
        for(int i = 0; i < target; i++){
            if(i + 1 <= target){
                f[i+1] += f[i];
            }
            if(i + 2 <= target){
                f[i+2] += f[i];
            }
        }
        return f[target];
    }
}
