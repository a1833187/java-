package qrxedu.algorithm.day18;

/**
 * 判断无序数组中是否存在三个递增的序列，不要求连续
 * 时间复杂度：O(n)   空间复杂度：O(1)
 * 贪心+双指针
 * @author qiu
 * @version 1.8.0
 */
public class Solution1 {
    public boolean increasingTriplet(int[] nums){
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < first){
                //不需要更新second，虽然这次更新结束后，first位于second的后面，但在second的前面一定存在
                //一个比second小的元素
                //这里更新了反而有些实例通过不了，比如 ： 12 8 36 4 40，形如 A B C D，满足C < A < B < D的
                first = nums[i];
            }else if(nums[i] > first && nums[i] < second){
                second = nums[i];
            }else if(nums[i] > first && nums[i] > second){
                return true;
            }
        }
        return false;
    }
}
