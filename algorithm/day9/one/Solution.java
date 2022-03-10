package qrxedu.algorithm.day9.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个整型数组中只有两个数字出现了一次，其他数字出现了两次。
 * 异或，将整个数组中的元素进行异或，根据异或后得到的数据中的二进制中的某个值为1的位置将整个数据进行分组
 * 可以得知分到的两个组中相同的元素一定出现在同一组中，两个不同的只出现一次的数字一定被分在了两个组里面
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<Integer> findNumsAppearOnce(int[] array){
        List<Integer> list = new ArrayList<>();
        if(array == null || array.length == 0){
            return list;
        }
        int result = array[0];
        for(int i = 1; i < array.length;i++){
            result = result ^ array[i];
        }
        int num1 = 0;
        int num2 = 0;
        int size = Integer.SIZE;
        int flag = 1;
        int i = 0;
        while(size > 0){
            if(((flag<<i) & result) != 0){
                flag <<= i;
                break;
            }
            i++;
            size--;
        }
        for(int j = 0; j < array.length;j++){
            if((array[j] & flag) == 0){
                num1 = num1 ^ array[j];
            }else{
                num2 = num2 ^ array[j];
            }
        }
        list.add(num1);
        list.add(num2);
        return list;
    }
}
