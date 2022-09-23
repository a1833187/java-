package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E97 {
    public int[] solve (int n, int m, int[] a) {
        // write code here
        m = m % n;
        reverse(a,0,n-m-1);
        reverse(a,n-m,n-1);
        reverse(a,0,n-1);
        return a;
    }
    public void reverse(int[] a,int l,int r){
        while(l < r){
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
            l++;
            r--;
        }
    }
}
