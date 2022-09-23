package qrxedu.algorithm.day5.four;

/**
 * 判断某个二叉搜索树的后序遍历是否合理
 *
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int i = start;
        while (i <= end && sequence[i] < sequence[end]) {
            i++;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }
        return verifySequenceOfBST(sequence, start, i - 1) &&
                verifySequenceOfBST(sequence, i, end - 1);
    }
}
