package qrxedu.leedcode699;

import java.util.ArrayList;
import java.util.List;

/**
 * 正方形俄罗斯方块
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> heigths = new ArrayList<>();
        int n = positions.length;

        for(int i = 0; i < n; i++){
            int left1 = positions[i][0];
            int right1 = left1 + positions[i][1];
            int heigth1 = positions[i][1];
            for(int j = 0; j < i; j++){
                int left2 = positions[j][0];
                int right2 = positions[j][0] + positions[j][1];
                if(left1 < right2 && right1 > left2){
                    heigth1 = Math.max(heigth1,heigths.get(j)+positions[i][1]);
                }
            }
            heigths.add(heigth1);
        }
        for(int i = 1; i < heigths.size(); i++){
            heigths.set(i,Math.max(heigths.get(i),heigths.get(i-1)));
        }
        return heigths;
    }
}
