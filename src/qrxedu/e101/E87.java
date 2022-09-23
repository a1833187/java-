package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E87 {
    public void merge(int A[], int m, int B[], int n) {
        int i = m-1;
        int j = n-1;
        for(int k = m+n-1; k >= 0; k--){
            if(j < 0 ||(i >= 0 && A[i] > B[j])){
                A[k] = A[i];
                i--;
            }else{
                A[k] = B[j];
                j--;
            }
        }

    }
}
