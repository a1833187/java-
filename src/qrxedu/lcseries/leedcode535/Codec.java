package qrxedu.lcseries.leedcode535;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * URL解密加密
 * @author qiu
 * @version 1.8.0
 */
public class Codec {
    // Encodes a URL to a shortened URL.
    Map<String,String> map = new HashMap<>();
    public String encode(String longUrl) {
        String a = "http://tinyurl.com/";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(a);
        int i = 6;
        while(i != 0){
            char c = (char)(random.nextInt(74) + 48);
            sb.append(c);
            i--;
        }
        map.put(sb.toString(),longUrl);
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
    @Test
    public void show(){
        System.out.println(encode("https://leetcode.com/problems/design-tinyurl"));

    }
}
