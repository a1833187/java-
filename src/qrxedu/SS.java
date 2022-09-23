package qrxedu;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class SS {
    public boolean sort(String str){
       return str.toLowerCase() == "admin";
    }
    @Test
    public void show(){
        String a = "abc";
        String b = "ab";
        String c = "c";
        System.out.println(a=="ab"+"c");
    }
}
