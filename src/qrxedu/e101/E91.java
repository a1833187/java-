package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E91 {
    public String solve (String str) {
        // write code here
        String ans = "";
        for(int i = str.length()-1; i >= 0; i--){
            ans += str.charAt(i);
        }
        return ans;
    }
}
