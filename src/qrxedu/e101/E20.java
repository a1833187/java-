package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E20 {
    static final int MOD = 1000000007;
    public int ans = 0;
    public int InversePairs(int [] array) {
        int n = array.length;
        if(n <= 1){
            return 0;
        }
        int[] temp = new int[n];
        InversePairs(array,0,n-1,temp);
        return ans;
    }
    private void InversePairs(int[] arr,int l,int r,int[] temp){
        if(l < r){
            int mid = l + r >> 1;
            InversePairs(arr,l,mid,temp);
            InversePairs(arr,mid+1,r,temp);
            merge(arr,l,mid,r,temp);
        }
    }
    private void merge(int[] arr,int l,int mid,int r,int[] temp){
        for(int i = l;i <= r;i++){
            temp[i-l] = arr[i];
        }
        int i1 = 0;
        int i2 = mid - l + 1;
        int n1 = mid - l + 1;
        int n2 = r - l + 1;
        while(i1 < n1 && i2 < n2){
            if(temp[i1] > temp[i2]){
                ans += n1 -i1;
                ans %= MOD;
                arr[l++] = temp[i2++];
            }else{
                arr[l++] = temp[i1++];
            }
        }
        if(i1 == n1){
            for(; i2 < n2; i2++){
                arr[l++] = temp[i2];
            }
        }else{
            for(;i1 < n1; i1++){
                arr[l++] = temp[i1];
            }

        }

    }
}
