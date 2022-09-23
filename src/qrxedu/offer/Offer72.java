package qrxedu.offer;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer72 {
    public int strToInt(String str) {
        int n = str.length();
        char start = ' ';
        int idx = 0;
        for(int i = 0; i < n; i++){
            if(str.charAt(i) == ' '){
                continue;
            }
            idx = i;
            start = str.charAt(i);
            if(!((start >= '0' && start <= '9') || start == '-' || start == '+')){
                return 0;
            }
            break;
        }
        boolean flag = false;
        if(start == '-' || start == '+'){
            idx++;
            if(start == '-'){
                flag = true;
            }
        }
        long ans = 0;
        for(;idx < n;idx++){
            char ch = str.charAt(idx);
            if(!(ch >= '0' && ch <= '9')){
                break;
            }
            ans = ans * 10 + (int)(ch-48);
            if(ans > Integer.MAX_VALUE){
                if(flag){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }
        }
        if(flag){
            ans = ans * -1;
        }
            return (int)ans;

    }
}
