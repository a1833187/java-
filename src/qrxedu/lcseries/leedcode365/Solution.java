package qrxedu.lcseries.leedcode365;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        int minC = Math.min(jug1Capacity,jug2Capacity);
        int maxC = Math.max(jug1Capacity,jug2Capacity);
        int target = targetCapacity;
        if(target > minC + maxC){
            return false;
        }
        if(target % minC == 0 || target == minC + maxC || target == maxC || target == maxC - minC){
            return true;
        }
        boolean[] flag = new boolean[maxC];
        int remain = 0;
        while(!flag[remain]){
            flag[remain] = true;
            remain = (remain + minC) % maxC;
            if(remain == target || remain + maxC == target){
                return true;
            }
        }
        return false;
    }
}
