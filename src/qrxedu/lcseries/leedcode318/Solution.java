package qrxedu.lcseries.leedcode318;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] dict = new int[n];
        for(int i = 0; i < n; i++){
            String str = words[i];
            for(int j = 0; j < str.length();j++){
                char ch = str.charAt(j);
                int k = (int)(ch-97);
                if(((dict[i] >> k) & 1) == 1){
                    continue;
                }
                dict[i] += 1<<k;
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if((dict[i] & dict[j]) == 0){
                    ans = Math.max(ans,words[i].length()*words[j].length());
                }
            }
        }
        return ans;
    }

}
