package qrxedu.lcseries.leedcode299;

import org.junit.jupiter.api.Test;

/**
 * 数字转化为字符串： num --- > "" + num
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        int[] count = new int[10];
        for(int i = 0; i < secret.length();i++){
            count[secret.charAt(i) - '0']++;
        }
        int gong = 0,mu = 0;
        for(int i = 0; i < len; i++){
            if(guess.charAt(i) == secret.charAt(i)){
                gong++;
                count[guess.charAt(i) - '0']--;
            }
        }
        for(int i = 0; i < len; i++){
            if(guess.charAt(i) != secret.charAt(i) && count[guess.charAt(i)-'0'] != 0){
                mu++;
                count[guess.charAt(i) - '0']--;
            }
        }
        String a = "" + gong;
        String b = "" + mu;
        StringBuilder res = new StringBuilder();
        res.append(a);
        res.append('A');
        res.append(b);
        res.append('B');
        return res.toString();
    }

    @Test
    public void show(){
        System.out.println(getHint("1122","1222"));
    }
}
