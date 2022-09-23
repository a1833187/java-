package qrxedu.lcseries.leedcode96;


/**
 * 数学方式去求解前序遍历二叉搜索树的种类数
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int numTrees(int n) {
       int[] f = new int[n+1];
       f(f);
       return f[n];
    }
    public void f(int[] f){
        f[0] = 1;
        for(int i = 1; i <f.length;i++){
            int m = 0;
            for(int j = 1; j <=i;j++){
                m +=f[j-1]*f[i-j];
            }
            f[i] = m;
        }
    }

}
