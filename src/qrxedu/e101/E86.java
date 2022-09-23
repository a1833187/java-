package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E86 {
    public String solve (String s, String t) {
        // write code here
        int m = s.length();
        int n = t.length();
        if(m == 0){
            return t;
        }else if(n == 0){
            return s;
        }
        int k = 0;
        int i = m-1,j = n-1;
        StringBuilder res = new StringBuilder();
        while(i >= 0 && j >= 0){
            int num1 = Integer.parseInt(s.charAt(i)+"");
            int num2 = Integer.parseInt(t.charAt(j)+"");
            int ans = num1 + num2 + k;
            res.insert(0,(ans%10)+"");
            if(ans >= 10){
                k = 1;
            }else{
                k = 0;
            }
            i--;
            j--;
        }
        if(i > 0){
            while(i >= 0){
                int num1 = Integer.parseInt(s.charAt(i)+"");
                int ans = num1 + k;
                res.insert(0,(ans%10)+"");
                if(ans >= 10){
                    k = 1;
                }else{
                    k = 0;
                }
                i--;
            }
            if(k == 1){
                res.insert(0,1+"");
            }
        }else{
            while(j >= 0){
                int num2 = Integer.parseInt(t.charAt(j)+"");
                int ans = num2 + k;
                res.insert(0,(ans%10)+"");
                if(ans >= 10){
                    k = 1;
                }else{
                    k = 0;
                }
                j--;
            }
            if(k == 1){
                res.insert(0,1+"");
            }
        }
        return new String(res);
    }
}
