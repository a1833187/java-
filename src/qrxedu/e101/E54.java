package qrxedu.e101;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E54 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(num);
        int n = num.length;
        int a = 0, b = 1, c = n-1;
        for(; a < n - 2; a ++){
            //消除重复元素导致的重复结果
            if(a > 0 && num[a] == num[a-1]){
                continue;
            }
            int t = num[a] * -1;
            b = a + 1;
            c = n - 1;
            while(b < c){
                while(b < c && num[c] + num[b] > t){
                    c--;
                }
                if(b >= c){
                    break;
                }
                if(num[c] + num[b] == t){
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(num[a]);
                    l.add(num[b]);
                    l.add(num[c]);
                    ans.add(l);
                    //如果当前情况下存在满足条件的结果,为了避免出现重复,应该提前消除"一个重复元素",这里消除的是b
                    while(b < c && num[c-1] == num[c]){
                        c--;
                    }
                    b++;
                    while(b < c && num[b] == num[b-1]){
                        b++;
                    }
                }else{
                    b++;
                }
            }
        }
        return ans;
    }
    @Test
    public void show(){
        int[] arr = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(threeSum(arr));
    }
}
