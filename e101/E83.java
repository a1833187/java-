package qrxedu.e101;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E83 {
    public String trans(String s, int n) {
        // write code here
        if(n == 1){
            return s;
        }
        char[] arr = s.toCharArray();
        for(int i = 0; i < n; i++){
            char ch = arr[i];
            if(ch == ' '){
                continue;
            }
            if(ch >= 'A' && ch <= 'Z'){
                arr[i] += 32;
            }else{
                arr[i] -= 32;
            }
        }
        int l = 0,r = 0;
        while(r < n){
            while(r < n && arr[r] != ' '){
                r++;
            }
            reverse(arr,l,r-1);
            r++;
            l = r;
        }
        reverse(arr,0,n-1);
        return new String(arr);
    }
    public void reverse(char[] arr, int l, int r){
        while(l < r){
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }
    @Test
    public void show(){
        System.out.println(trans("This is a sample",16));
    }
}
