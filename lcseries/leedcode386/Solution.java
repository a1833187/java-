package qrxedu.leedcode386;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典序排数(O(n)):将1~n按字典序排序.
 * 按照字典树的前序遍历.
 * 字典树的特点:每一个节点j的子节点的范围都是[j*10,j*10+9]
 * 由任意子节点返回节点:j/=10;
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        int number = 1;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ans.add(number);
            if(number * 10 <= n){
                number*=10;
            }else{
                while(number + 1 > n || number % 10 == 9){
                    number /= 10;
                }
                number++;
            }
        }
        return ans;
    }
}
