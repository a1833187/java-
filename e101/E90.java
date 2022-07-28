package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E90 {
    public String minWindow (String S, String T) {
        // write code here
        int cnt = S.length() + 1;
        int[] hash = new int[128];
        for(int i = 0; i < T.length(); i++){
            hash[T.charAt(i)] -= 1;
        }
        int slow = 0,fast = 0;
        int left = -1,right = -1;
        while(fast < S.length()){
            char ch = S.charAt(fast);
            hash[ch]++;
            while(isV(hash)){
                if(cnt > fast - slow +1){
                    cnt = fast - slow + 1;
                    left = slow;
                    right = fast;
                }
                ch = S.charAt(slow);
                hash[ch]--;
                slow++;
            }
            fast++;
        }
        if(left == -1){
            return "";
        }
        return S.substring(left,right+1);
    }
    public boolean isV(int[] hash){
        int n = hash.length;
        for(int i = 0; i < n; i++){
            if(hash[i] < 0){
                return false;
            }
        }
        return true;
    }
}
