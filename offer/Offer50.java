package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        if(s.length() == 0){
            return ' ';
        }
        int len = s.length();
        int[] cnt = new int[26];
        for(int i = 0; i < len; i++){
            cnt[(s.charAt(i) - 'A')]++;
        }
        for(int i = 0; i < len; i++){
            if(cnt[s.charAt(i) - 'A'] == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
