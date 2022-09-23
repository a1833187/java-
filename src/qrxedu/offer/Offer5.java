package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer5 {
    public String replaceSpace(String s) {
        StringBuilder curS = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(curS.charAt(i) == ' '){
                curS.append("%20");
            }else{
                curS.append(s.charAt(i));
            }
        }
        return new String(curS);
    }
}
