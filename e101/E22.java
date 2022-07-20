package qrxedu.e101;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E22 {
    public int compare (String version1, String version2) {
        // write code here
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i1 = 0,i2 = 0,n1 = v1.length,n2 = v2.length;
        while(i1 < n1 && i2 < n2){
            int num1 = Integer.parseInt(v1[i1]);
            int num2 = Integer.parseInt(v2[i2]);
            if(num1 < num2){
                return -1;
            }else if(num1 > num2){
                return 1;
            }else{
                i1++;
                i2++;
            }
        }
        if(i1 == n1){
            while(i2 < n2){
                if(Integer.parseInt(v2[i2]) == 0){
                    i2++;
                    continue;
                }else{
                    break;
                }
            }
            if(i2 == n2){
                return 0;
            }
            return -1;
        }else if(i2 == n2){
            while(i1 < n1){
                if(Integer.parseInt(v1[i1]) == 0){
                    i1++;
                    continue;
                }else{
                    break;
                }
            }
            if(i1 == n1){
                return 0;
            }
            return 1;
        }
        return 0;
    }
    @Test
    public void show(){
        String v1 = "1.0";
        String v2 = "1.0.0";
        System.out.println(compare(v1,v2));
    }
}
