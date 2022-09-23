package qrxedu.l612;

/**
 * @author qiu
 * @version 1.8.0
 */
public class S1 {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0;
        int m = brackets.length;
        for(int i = 0; i < m && income >= 0; i++){
            int up;
            if(i > 0){
                up = brackets[i][0] - brackets[i-1][0];
            }else{
                up = brackets[i][0];
            }
            double per = brackets[i][1] * 1.0 / 100;
            if(income >= up){
                ans += up * per;
            }else{
                ans += income * per;
            }
            income -= up;
        }
        return ans;
    }
}
