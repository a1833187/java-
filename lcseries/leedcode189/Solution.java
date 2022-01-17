package com.qrxedu.leedcode189;


/**
 * 数组中元素统一向后移动k个位置
 * 某个位置的元素每次向后移动k个位置，在经历数组中所有元素的前提下，会出现两种情况
 * 1.该元素最终遍历完了数组中所有位置，如1,2,3,4,5,6,7,  k = 3
 * 2.该元素最终移动到了初始的位置， 如1,2,3,4, k = 2
 * 对于第一种情况，我们是非常乐于见到的。
 * 对于第二种情况，我们可以将有限个元素移动到k个位置，每个元素都以移动到原来的位置为结束标准直到数组中
 * 所有位置都被遍历过
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int count = 0;
        int i = 0;
        int num = nums[i];
        int len = nums.length;
        k = k < len ? k : k % len;
        if (k == 0 || k == len) {
            return;
        }
        for (int j = 0; j < k; j++) {
            i = j;
            num = nums[i];
            int tmp = nums[(i + k) % len];
            nums[(i + k) % len] = num;
            num = tmp;
            i = (i + k) % len;
            count++;
            while (i != j) {
                tmp = nums[(i + k) % len];
                nums[(i + k) % len] = num;
                num = tmp;
                i = (i + k) % len;
                count++;
            }
            if(count == len){
                break;
            }
        }
    }
    /**
     * 数组的翻转
     * 对于任意一个数组，如1,2,3,4,5,6,7  k = 3这种情况，最终数组变为5,6,7,1,2,3,4
     * 可以把数组看成两部分；一部分是 [begin,end-k),这部分是移动到数组后面
     * 一部分是[end-k,end),这部分数组移动到数组的前面
     * 所以1.先把第一部分数组进行翻转，2.再把第二部分数组翻转得到4,3,2,1,7,6,5
     * 3.然后翻转整个数组得到最终结果：5,6,7,1,2,3,4
     */

}
