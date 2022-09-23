package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer62 {
    public String reverseLeftWords(String s, int n) {
        String ans = s + s;
        int len = s.length();
        return ans.substring(n,n+len);
    }
}
