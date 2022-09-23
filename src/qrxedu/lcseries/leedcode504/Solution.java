package qrxedu.lcseries.leedcode504;

/**
 * 有序数组中的单一元素:O(log(n))
 * key的左侧 奇数下标的元素都和前一个元素的值相同,偶数下标的值都和后一个值相同
 * key的右侧  奇数下标的元素都和后一个元素的值相同,偶数下标的值都和前一个值相同
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int l = 0, r= n-1;
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(mid % 2 == 0){
                if(mid - 1 >= 0 && nums[mid] == nums[mid-1]){
                    r = mid - 1;
                }else{
                    l = mid;
                }
            }else{
                if(mid + 1 < n && nums[mid] == nums[mid+1]){
                    r = mid - 1;
                }else{
                    l = mid;
                }
            }
        }
        return nums[l];
    }
}
