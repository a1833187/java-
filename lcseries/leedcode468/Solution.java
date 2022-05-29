package qrxedu.leedcode468;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String validIPAddress(String queryIP) {
        if(queryIP == null || queryIP.length() == 0){
            return "Neither";
        }
        if(queryIP.charAt(queryIP.length()-1) == '.' || queryIP.charAt(queryIP.length()-1) == ':'){
            return "Neither";
        }
        if(queryIP.charAt(0) == '.' || queryIP.charAt(0) == ':'){
            return "Neither";
        }
        if(queryIP.contains(".")){
            String[] s = queryIP.split("\\.");
            if(s.length != 4){
                return "Neither";
            }
            for(String str : s){
                if(str.length() < 1 || str.length() > 3){
                    return "Neither";
                }
                if(str.charAt(0) == '0' && str.length() != 1){
                    return "Neither";
                }
                for(int i = 0; i < str.length(); i++){
                    if(!(str.charAt(i) >= '0' && str.charAt(i) <= '9')){
                        return "Neither";
                    }
                }
                int num = Integer.parseInt(str);
                if(num < 0 || num > 255){
                    return "Neither";
                }

            }
            return "IPv4";
        }else if(queryIP.contains(":")){
            String[] s = queryIP.split(":");
            if(s.length != 8){
                return "Neither";
            }
            for(String str : s){
                if(str.length() < 1 || str.length() > 4){
                    return "Neither";
                }
                for(int i = 0; i < str.length(); i++){
                    if((str.charAt(i) >= 'g' && str.charAt(i) <='z') || (str.charAt(i) >= 'G' && str.charAt(i) <= 'Z')){
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }else{
            return "Neither";
        }
    }
    @Test
    public void show(){
        String Ip = "12..33.4";
        System.out.println(validIPAddress(Ip));
    }
}
