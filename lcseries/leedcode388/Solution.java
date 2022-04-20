package qrxedu.leedcode388;


/**
 * 文件的最长绝对路径
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    //太秀了
    public int lengthLongestPath(String input) {
        int n = input.length();
        //layer[i]表示的是当前层及之前的所有层的文件的长度
        //因为求的是最后的文本的绝对路径的长度,所以不需要存储最后一层的文本的长度.
        int[] layer = new int[n+1];
        int pos = 0;
        int ans = 0;
        while(pos < n){
            int depth = 1;
            //每个文件前有多少个制表符就说明该文件处于第几层
            while(pos < n && input.charAt(pos) == '\t'){
                depth++;
                pos++;
            }
            boolean isFile = false;
            int len = 0;
            //每次循环完以后都使pos指向某个文件名前的\t上
            while(pos < n && input.charAt(pos) != '\n'){
                if(input.charAt(pos) == '.'){
                    isFile = true;
                }
                len++;
                pos++;
            }
            pos++;
            if(depth>1){
                //大于第一层文件与文件之间需要加一个'/',所以要+1
                len+=layer[depth-1]+1;
            }
            if(isFile){
                ans = Math.max(ans,len);
            }else{
                layer[depth] = len;
            }
        }
        return ans;
    }

}
