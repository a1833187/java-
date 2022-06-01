package train2016;

import java.util.Arrays;
import java.util.HashSet;

public class Main3 {
    public static HashSet<String> set = new HashSet<String>();
    
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    public void dfsAllSort(int[] A, int step) {
        if(step == A.length) {
            long[] B = new long[A.length];
            dfsSqrtNum(A, 0, B, 0);
            return;
        } else {
            for(int i = step;i < A.length;i++) {
                swap(A, i, step);
                dfsAllSort(A, step + 1);
                swap(A, i, step);
            }
        }
    }
    
    public void dfsSqrtNum(int[] A, int step, long[] B, int num) {
        if(step == A.length) {
            StringBuffer s = new StringBuffer("");
            long[] arrayA = new long[num];
            for(int i = 0;i < num;i++)
                arrayA[i] = B[i];
            Arrays.sort(arrayA);
            for(int i = 0;i < num;i++) {
                s.append(arrayA[i]);
                if(i != num - 1)
                    s.append("-");
            }
            System.out.println(s);
            set.add(s.toString());
            return;
        }
        
        if(A[step] == 0) {
            B[num] = 0;
            dfsSqrtNum(A, step + 1, B, num + 1);
        } else { 
            long sum = 0;
            for(int i = step;i < A.length;i++) {
                sum = sum * 10 + A[i];
                double son = Math.sqrt(sum * 1.0);
                long a = (long) son;
                if(a == son) {
                    B[num] = sum;
                    //下一轮只能使用i之后的值,不能使用i之前的值
                    dfsSqrtNum(A, i + 1, B, num + 1);
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        Main3 test = new Main3();
        int[] A = {0,1,2,3,4,5,6,7,8,9};
        test.dfsAllSort(A, 0);
        System.out.println(set.size());
    }
}
