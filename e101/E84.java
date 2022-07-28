package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E84 {
    public String longestCommonPrefix (String[] strs) {
        // write code here
        int n = strs.length;
        if(n == 0){
            return "";
        }
        if(n == 1){
            return strs[0];
        }
        String ans = "";
        int m = strs[0].length();
        for(int i = 0; i < m; i++){
            char ch = strs[0].charAt(i);
            for(int j = 1; j < n; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != ch){
                    return ans;
                }
            }
            ans += ch;
        }
        return ans;

    }
}
