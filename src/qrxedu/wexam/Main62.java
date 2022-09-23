package qrxedu.wexam;

import java.util.Scanner;

/**
 * 根据前序遍历和后续遍历求出m叉树的不同种类的个数.
 * 根据前序得到根节点,根据后续遍历得到该节点的子树有几个num.对应的方案就是C[n][num]
 * 递归到最后只剩一个节点,返回1.
 * @author qiu
 * @version 1.8.0
 */
public class Main62 {
    static long[][] dp = new long[21][21];
    static{
        for(int i = 0; i < 21; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < 21; i++){
            for(int j = 1; j <= i; j++){
                dp[i][j] = dp[i-1][j-1] * i / j;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            String pre = scanner.next();
            String post = scanner.next();
            System.out.println(dfs(n,pre,post));
        }
    }
    public static long dfs(int n,String pre,String post){
        //这里对pre的处理很关键.pre为1时
        if(pre.length() == 1){
            return 1;
        }
        pre = pre.substring(1);
        post = post.substring(0,post.length()-1);
        int k = 0;
        long sum = 1;
        int num = 0;
        while(k < pre.length()){
            for(int i = 0; i < post.length();i++){
                if(pre.charAt(k) == post.charAt(i)){
                    String curPre = pre.substring(k,i+1);
                    String curPost =  post.substring(k,i+1);
                    sum *= dfs(n, curPre, curPost);
                    num++;
                    k = i + 1;
                    break;
                }
            }
        }
        return sum * dp[n][num];
    }
}
