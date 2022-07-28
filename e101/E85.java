package qrxedu.e101;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E85 {
    public String solve (String IP) {
            // write code here
            int n = IP.length();
            boolean v4 = false;
            boolean v6 = false;
            if (IP.charAt(n - 1) == '.' || IP.charAt(n - 1) == ':') {
                return "Neither";
            }
            for (int i = 0; i < n; i++) {
                if (IP.charAt(i) == '.') {
                    v4 = true;
                }
                if (IP.charAt(i) == ':') {
                    v6 = true;
                }
            }
            if (v4 && v6) {
                return "Neither";
            }
            if (v4) {
                String[] ss = IP.split("\\.");
                if (ss.length != 4) {
                    return "Neither";
                }
                for (int i = 0; i < ss.length; i++) {
                    if (!isV4(ss[i])) {
                        return "Neither";
                    }
                }
                return "IPv4";
            } else if (v6) {
                String[] ss = IP.split(":");
                if (ss.length != 8) {
                    return "Neither";
                }
                for (int i = 0; i < ss.length; i++) {
                    if (!isV6(ss[i])) {
                        return "Neither";
                    }
                }
                return "IPv6";
            } else {
                return "Neither";
            }

        }
        public boolean isV4 (String s){
            if (s.length() == 0) {
                return false;
            }
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == '0') {
                    return false;
                }
            }
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!(ch >= '0' && ch <= '9')) {
                    return false;
                }
            }
            int num = Integer.parseInt(s);
            return num >= 0 && num <= 255;
        }
        public boolean isV6 (String s){
            if (s.length() == 0 || s.length() > 4) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F'))) {
                    return false;
                }
            }
            return true;
        }
    @Test
    public void show(){
        System.out.println(solve("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }
}
