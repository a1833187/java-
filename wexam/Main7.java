package qrxedu.wexam;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main7 {
    public int StrToInt(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        int flag = 1;
        if(str.charAt(0) == '-'){
            flag = -1;
        }
        int num = 0;
        int k = 0;
        int start = str.charAt(0) == '-' || str.charAt(0) == '+' ? 1 : 0;
        for(int i = str.length()-1;i>=start;i--){
            char ch = str.charAt(i);
            if(i == 0 && !(ch == '+' || ch == '-' || (ch >= '0' && ch <= '9'))){
                return 0;
            }else {
                if (ch >= '0' && ch <= '9') {
                    num += Math.pow(10,k++) * (int) (ch - '0');
                } else {
                    return 0;
                }
            }
        }
        return num*flag;
    }
    @Test
    public void show(){
        System.out.println(StrToInt("+2147483547"));
    }
}
