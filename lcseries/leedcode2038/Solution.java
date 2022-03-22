package qrxedu.leedcode2038;

import org.junit.jupiter.api.Test;

/**
 * 脑筋急转弯：三个相同的删除中间那个，看谁删除的多。 L个连续相同的可以删除的次数为L-2
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean winnerOfGame(String colors) {
        int resA = 0;
        int resB = 0;
        char ch = 'C';
        int cur = 0;
        for(int i = 0; i < colors.length(); i++){
            if(ch != colors.charAt(i)){
                ch = colors.charAt(i);
                cur = 1;
            }else{
                cur++;
                if(cur >= 3){
                    if(ch == 'A'){
                        resA++;
                    }else{
                        resB++;
                    }
                }
            }
        }
        return resA > resB;
    }
    @Test
    public void show(){
        String s = "BBBAAAABB";
        System.out.println(winnerOfGame(s));
    }
}
