package qrxedu.lcseries.leedcode443;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int compress(char[] chars) {
        if(chars == null || chars.length == 0){
            return 0;
        }
        int k = 0;
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            int count = 1;
            while(i+1 < chars.length && i < chars.length - 1 && chars[i] == chars[i+1]){
                count++;
                i++;
            }
            if(count == 1){
                chars[k++] = chars[i];
                sum++;
            }else{
                sum++;
                chars[k++] = chars[i];
                int count1 = 0;
                int m = count;
                while(count != 0){
                    count1++;
                    count /= 10;
                }
                sum+=count1;
                int p = count1;
                while(p>0){
                    int l = (int)((Math.pow(10,p-1)));
                    chars[k++] = (char)(48 + (m/l)%10);
                    p--;
                }
            }
        }
        return sum;
    }
    @Test
    public void show(){
        char[] chars = {'a'};
        System.out.println(compress(chars));
    }
}
