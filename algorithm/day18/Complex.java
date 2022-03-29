package qrxedu.algorithm.day18;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Complex {
    public String complexMul(String str1,String str2){
        int[] ab1 = new int[2];
        int[] ab2 = new int[2];
        transform(str1,ab1);
        transform(str2,ab2);
        int a = ab1[0]*ab2[0] - ab1[1]*ab2[1];
        int b = ab1[0]*ab2[1] + ab1[1]*ab2[0];
        StringBuffer sb = new StringBuffer();
        sb.append((char)a);
        if(b >= 0){
            sb.append('+');
        }
        sb.append((char)b);
        sb.append('i');
        return sb.toString();
    }
    public void transform(String str,int[] ab){
        ab[0] = str.charAt(0) == '-' ? -1 : 1;
        int start1 = str.charAt(0) >='0' && str.charAt(0) <= '9' ? 0 : 1;
        int i = start1;
        for(; i < str.length();i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                continue;
            }
            ab[0]*=Integer.parseInt(str.substring(start1,i));
            break;
        }
        ab[1] = str.charAt(i) == '-' ? -1 : 1;
        ab[1] *= Integer.parseInt(str.substring(i+1,str.length()-1));
    }
}
