package qrxedu.leedcode4;

/**
 * 寻找两个正序数组中的中位数 O(log(m+n))
 * 中位数即 第k小的元素.(当m+n为奇数时,k = (m+n)/2;偶数时,k = (m+n)/2 + (m+n)/2 + 1)
 * 对于第k小的元素,我们可以先比较nums1中第k/2-1元素和nums2中第k/2-1的元素的大小,其中的较小值以及该值前面内的所有
 * 值都被去掉,原因是比较小值小的元素最多有 k/2-1+k/2-1 = k-2个,所以直接去掉这一部分.
 * 然后在剩余的数组里面继续比较,同时要更新k,k为k-去掉的元素个数.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if(total % 2 == 1){
            int length = total / 2 + 1;
            return getK(nums1,nums2,length)*1.0;
        }else{
            int length1 = total / 2;
            int length2 = total / 2 + 1;
            return (getK(nums1,nums2,length1) + getK(nums1,nums2,length2)) / 2.0;
        }
    }
    public int getK(int[] nums1,int[] nums2,int k){
        int m = nums1.length;
        int n = nums2.length;
        int index1 = 0,index2 = 0;
        while(true){
            if(index1 == m){
                return nums2[k + index2 - 1];
            }
            if(index2 == n){
                return nums1[k + index1 - 1];
            }
            if(k == 1){
                return Math.min(nums1[index1],nums2[index2]);
            }
            int half = k / 2;
            int i1 = Math.min(index1 + half,m)-1;
            int i2 = Math.min(index2 + half,n)-1;
            if(nums1[i1] <= nums2[i2]){
                k -= i1-index1+1;
                index1 = i1 + 1;
            }else{
                k -= i2 - index2 + 1;
                index2 = i2 + 1;
            }
        }

    }
}
