package qrxedu.algorithm.day13.two;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    /*
    编辑距离：F{i,j)表示word1中前i个字符转换成word2中前j个字符的最小操作次数
            F(i-1,j) --->F(i,j) 只需要删除word1中的第i个字符
            F(i,j-1) --->F(i,j) 只需要向word1中添加t中的第j个字符
            F(i-1,j-1) --->F(i,j) 当s[i]==t[j]不需要操作，否则将s[i]替换成t[j]
            所以F(i,j) = min(F(i-1)+1,F(i,j-1)+1,F(i-1,j-1)+(s[i] != t[j] ? 1:0))
     */

}
