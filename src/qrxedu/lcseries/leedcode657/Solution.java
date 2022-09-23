package qrxedu.lcseries.leedcode657;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean judgeCircle(String moves) {
        int ud = 0;
        int lr = 0;
        for(int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == 'L'){
                lr--;
            }
            if(moves.charAt(i) == 'R'){
                lr++;
            }
            if(moves.charAt(i) == 'U'){
                ud--;
            }
            if(moves.charAt(i) == 'D'){
                ud++;
            }
        }
        return ud == 0 && lr == 0;
    }
}
