package exam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main {
    static String add(String a, String b) {
        // Please fill this blank
        Map<Character,Integer> dict = new HashMap<>();
        for(int i = 0; i < 26; i++){
            dict.put((char)('a'+i),i+10);
        }
        for(int i = 0; i < 9; i++){
            dict.put((char)(i+48),i);
        }
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        int m = A.length;
        int n = B.length;
        char[] C = new char[Math.max(m,n)+1];
        int i = m-1,j = n-1;
        int k = C.length-1;
        int jin = 0;
        while(i >= 0 && j >= 0){
            char a1 = A[i];
            char b1 = B[j];
            int A1 = dict.get(a1);
            int B1 = dict.get(b1);
            int num = A1 + B1 + jin;
            jin = num / 36;
            int val = num %36;
            if(val >= 10 && val <= 35){
                C[k--] = (char)(val-10+'a');
            }else{
                C[k--] = (char)(val+48);
            }
            i--;
            j--;
        }
        if(i >= 0){
            while(i >= 0){
                int A1 = dict.get(A[i]);
                int num = A1 + jin;
                jin = num / 36;
                int val = num %36;
                if(val >= 10 && val <= 35){
                    C[k--] = (char)(val-10+'a');
                }else{
                    C[k--] = (char)(val+48);
                }
                i--;
            }
        }else{
            while(j >= 0){
                int B1 = dict.get(B[i]);
                int num = B1 + jin;
                jin = num / 36;
                int val = num %36;
                if(val >= 10 && val <= 35){
                    C[k--] = (char)(val-10+'a');
                }else{
                    C[k--] = (char)(val+48);
                }
                j--;
            }
        }
        if(jin == 1){
            C[0] = '1';
            return new String(C);
        }else{
            char[] ans = new char[C.length-1];
            for(int l = 0; l < ans.length; l++){
                ans[l] = C[l+1];
            }
            return new String(ans);
        }
    }
//
//    public static void main(String[] args) {
//       String s1 = "zzzz";
//       String s2 = "1";
//        System.out.println(add(s1,s2));
//    }

}
