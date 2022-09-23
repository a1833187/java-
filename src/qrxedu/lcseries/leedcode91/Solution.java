package qrxedu.lcseries.leedcode91;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int numDecodings(String s) {
        if((s == null || s.length() == 0 || s.charAt(0) == '0')){
            return 0;
        }
        String str = s;
        if(str.length() == 1){
            return 1;
        }
        int[] f = new int[str.length()];
        for(int i = 1; i < str.length();i++){
            if(str.charAt(i) == '0' && (str.charAt(i-1) > '2' || str.charAt(i-1) == '0')){
                return 0;
            }
        }
        f[0] = 1;
        int k = Integer.parseInt(str.substring(0,2));
        if(str.charAt(1) == '0' || k > 26){
            f[1] = 1;
        }else{
            f[1] = 2;
        }
        for(int i = 2; i < str.length();i++){
            int k1 = Integer.parseInt(str.substring(i-1,i+1));
            if(str.charAt(i) == '0'){
                f[i] = f[i-2];
            }else if(k1 > 26 || str.charAt(i-1) == '0'){
                f[i] = f[i-1];
            }else{
                f[i] = f[i-1] + f[i-2];
            }
        }
        return f[str.length()-1];
    }
}
