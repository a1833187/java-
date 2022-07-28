package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E88 {
    public boolean judge (String str) {
        // write code here
        int l = 0, r = str.length()-1;
        while(l < r){
            char s = str.charAt(l);
            char e = str.charAt(r);
            if(s != e){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
